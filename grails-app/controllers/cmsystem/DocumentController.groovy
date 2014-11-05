package cmsystem

import org.springframework.web.multipart.commons.CommonsMultipartFile
import org.codehaus.groovy.grails.web.context.ServletContextHolder
import grails.util.GrailsUtil
//import grails.converters.*
/*import java.lang.**/

class DocumentController {

	boolean transactional = true
	
    def index() { }
	
	/*def show = {
		if(params.id && Document.exists(params.id)) {
			render Document.findById(params.id) as XML
		} else {
			render Document.list() as XML
		}
	}*/
	
	def documentUploadForm() { 
		[tagInstanceList: Tag.list()]
	}
	
	def documentDetails() {
		def documentInstance = Document.findById(params.id)
		[documentInstance: Document.load(params.id) , docTagInstance: DocTag.findAllWhere(document: documentInstance)]
	}
	
	def upload_Doc() {
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
		
	}

	def documentLibrary() {
        [documentInstanceList: Document.list(), documentInstanceTotal: Document.count()]
	}

	def deleteDocument() {
		def doc = Document.findById(params.id)
		
		if(doc)
		{
			doc.delete(flush: true)
			redirect(controller: "Document", action: "documentLibrary")
		}
	}

	def editDocumentForm() {
		[documentInstance: Document.load(params.id), tagInstanceList: Tag.list()]
	}

	def edit_Doc() {
		def doc = Document.findById(params.id)

		doc.docName = params.documentTitle
		doc.docDesc = params.docDesc

		doc.save(flush: true)
		
		//Tag fields need to be added
		redirect(controller: "Document", action: "documentLibrary")
		
	}

	def download_Doc() {
		def doc = Document.load(params.id)

		if (doc == null)
		{
			redirect(controller: "Document", action: "documentLibrary")
		}
		else
		{
			response.setContentType("APPLICATION/OCTET-STREAM")
            response.setHeader("Content-Disposition", "Attachment;Filename=\"${doc.docName}.${doc.fileType}\"")

            def outputStream = response.getOutputStream()
            outputStream << doc.file
            outputStream.flush()
            outputStream.close()
		}
	}
}