package cmsystem

import grails.converters.JSON

class DocumentController {

	boolean transactional = true
	
    def AuthController authController = new AuthController()
	
	def show = {
		if (authController.sessionActive()) {
			if(params.id && Document.exists(params.id)) {
				render Document.findById(params.id) as JSON
			} else {
				render Document.list() as JSON
			}
		}
	}
	
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
	
	/*def upload_Doc() {
	 def file = request.getFile('file')
	 def uploadedBy = UserAccount.findById(session.user.id)
	 if(file.empty)
	 {
		 flash.message = "File cannot be empty"
	 }
	 else
	 {
		 def documentInstance = new Document()
		 documentInstance.docName = params.documentTitle
		 documentInstance.file = file.bytes

		 //Code to get filetype explicitly
		 documentInstance.fileType = file.contentType.split("/")[1]
		 documentInstance.docDesc = params.docDesc
		 documentInstance.userAccount = uploadedBy
		 def theNewDocument = documentInstance.save(flush: true)

		 def tempArray = params.tags
		 for(i in tempArray)
		 {
			 def newEntry = new DocTag()
			 newEntry.tag = Tag.findById(i)
			 newEntry.document = theNewDocument
			 newEntry.save()

			 def tempEntry = new DocCategory()
			 tempEntry.document = theNewDocument
			 tempEntry.category = newEntry.tag.category
			 tempEntry.save()
		 }
	 }
	 
	 flash.message = "Document uploaded."
	 redirect(controller: "LandingPage", action: "renderHomePage")
	 
 }*/
}