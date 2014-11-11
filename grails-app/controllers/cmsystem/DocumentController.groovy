/**
	Document Controller class to enable RESTFUL API method calls.

	@authors Ananya Behera and Christian Sesta
	@version 9.2
	@datemodified 7th November 2014
*/

package cmsystem

import grails.converters.JSON

class DocumentController {

	boolean transactional = true
	
	/**
		The AuthController attribute allows for session management and method availability based on permission
		levels.
	*/
    def AuthController authController = new AuthController()
	
	/**
		The "show" method corresponds to the GET HTTP request and returns a list of Documents existing in the database 
		when an id is not specified, else it renders the specific desired document.  Document details are rendered in JSON format.

		@argument If an id is passed as an argument, the details of the corresponding Document are returned.
		@precondition None
		@postcondition None
		@return JSON formatted details of the desired document or documents
	*/
	def show = {
		if (authController.sessionActive()) {
			if(params.id && Document.exists(params.id)) {
				render Document.findById(params.id) as JSON
			} else {
				render Document.list() as JSON
			}
		}
	}
	
	/**
		The "create" method corresponds to the POST HTTP request and persists form data related to the creation of 
		a new Document into the database.  If successful, a 201 message is returned, else a 400 error.

		@argument The form data passes as fields within the 'params' argument.
		@precondition Atleast one tag must have been created as per functional requirements
		@postcondition A new document is created and added to the list of existing documents in the database.  In addition, 
						associating tables are updated accordingly
		@return Status message depending on whether the save was successful or not 
	*/
	def create = {
		if (authController.sessionActive() && authController.adminAccess()) {
			def file = request.getFile('file')
		
			if(file.empty) {
				render(status: 400, text: '400: Bad Request')
			} else {
				def document = new Document()
			
				document.documentName = params.documentTitle
				document.file = file.bytes
				document.fileType = file.contentType.split("/")[1]
				document.documentDesc = params.documentDesc
				document.userAccount = UserAccount.findById(session.user.id)
			
				if(document.save(flush: true)) {
					def tempArray = params.tags
				
					for(i in tempArray) {
						def tagEntry = new DocTag()
						def catgEntry = new DocCategory()
					
						tagEntry.tag = Tag.findById(i)
						tagEntry.document = document
						tagEntry.save()
				
						catgEntry.document = document
						catgEntry.category = tagEntry.tag.category
						catgEntry.save()
					}
					render(status: 201, text: '201: Created') as JSON
				} else {
					// Error handling section
					render(status: 400, text: '400: Bad Request') as JSON
				}
			}
		}
	}

	/**
		The "update" method corresponds to the POST HTTP request and updates an editable document in the database.
		If successful, the document details are rendered in JSON format, else a 400 error.

		@argument The form data passes as fields within the 'params' argument.
		@precondition Atleast one tag must have been created as per functional requirements
		@postcondition The existing document is updated with new data and saved to the database
		@return Status message depending on whether the save was successful or not 
	*/
	def update = {
		if (authController.sessionActive() && authController.adminAccess()) {
			if(params.id && Document.exists(params.id)) {
				def document = Document.findById(params.id)
				
				document.documentName = params.documentTitle
				document.documentDesc = params.documentDesc
						
				DocTag.executeUpdate("delete DocTag d where d.document = :doc", [doc: document])
				DocCategory.executeUpdate("delete DocCategory d where d.document = :doc", [doc: document])
				
				if(document.save(flush: true)) {
					def tempArray = params.tags
				
					for(i in tempArray) {
						def tagEntry = new DocTag()
						def catgEntry = new DocCategory()
					
						tagEntry.tag = Tag.findById(i)
						tagEntry.document = document
						tagEntry.save()
				
						catgEntry.document = document
						catgEntry.category = tagEntry.tag.category
						catgEntry.save()
					}
					render(status: 201, text: '201: Created') as JSON
				} else {
					// Error handling section
					render(status: 400, text: '400: Bad Request') as JSON
				}
			} else {
				render(status: 404, text: '404: Not Found') as JSON
			}	
		}
	}
	

	/**
		The "download" method enables system users to access and retrieve versions of files and documents in the
		database.
		
		@argument The id of the Document to be downloaded must be specified.
		@precondition The document to be downloaded must be already present in the database.
		@postcondition None
		@return Status message depending on whether the download was successful or not 
	*/
	def download = {
		if (authController.sessionActive()) {
			if(params.id && Document.exists(params.id)) {
				def doc = Document.load(params.id)
				def outputStream = response.getOutputStream()
				
				response.setContentType("APPLICATION/OCTET-STREAM")
				response.setHeader("Content-Disposition", "Attachment;Filename=\"${doc.documentName}.${doc.fileType}\"")
	
				outputStream << doc.file
				outputStream.flush()
				outputStream.close()
			} else {
				render(status: 404, text: '404: Not Found') as JSON
			}	
		}
	}
	
	/**
		The "remove" method corresponds to the DELETE HTTP request and removes the desired document from the database.
		Scaffold deleting features ensure that all bridging classes are updated accordingly
		
		@argument The id of the Document to be deleted must be specified.
		@precondition The document to be removed must be already present in the database.
		@postcondition The document is removed from the database and associated tables are also updated.
		@return Status message depending on whether the delete was successful or not 
	*/
	def remove = {
		if (authController.sessionActive() && authController.adminAccess()) {
			if(params.id && Document.exists(params.id)) {
				Document.load(params.id).delete(flush: true)
				render(status: 200, text: "200: OK") as JSON
			} else {
				// Error handling section
				render(status: 404, text: "404: Not Found")
			}
		}
	}
}