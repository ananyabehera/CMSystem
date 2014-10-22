package cmsystem

import org.springframework.web.multipart.commons.CommonsMultipartFile
import org.codehaus.groovy.grails.web.context.ServletContextHolder
import grails.util.GrailsUtil
/*import java.lang.**/

class DocumentController {

	boolean transactional = true
	
    def index() { }
	
	def documentUploadForm() {
		[tagInstanceList: Tag.list(), TagInstanceTotal: Tag.count()]
	}
	
	def documentDetails() {
		[documentInstance: Document.load(params.id)]
	}
	
	def upload_Doc() {
		def file = request.getFile('file')
		if(file.empty) {
			flash.message = "File cannot be empty"
		} else {
			def documentInstance = new Document()
			documentInstance.name = params.documentTitle
			documentInstance.file = file.bytes
			documentInstance.type = file.contentType
			documentInstance.documentDescription = params.docDesc
			if(!documentInstance.save(flush: true))
				render "Error Occured"
		}
		
		flash.message = "Document uploaded."
		redirect(controller: "AdminHome", action: "renderHomePage")
		
	}

	def renderListing() {
		//params.max = 1
        [documentInstanceList: Document.list(), documentInstanceTotal: Document.count()]
	}

	def deleteDocument() {
		def doc = Document.findById(params.id)
		
		if(doc)
		{
			doc.delete(flush: true)
			redirect(controller: "Document", action: "renderListing")
		}
	}

	def editDocumentForm() {
		[documentInstance: Document.load(params.id)]
	}

	def edit_Doc() {
		def doc = Document.findById(params.id)

		doc.name = params.documentTitle
		doc.documentDescription = params.docDesc

		doc.save(flush: true)
		
		//Tag fields need to be added
		redirect(controller: "AdminHome", action: "renderHomePage")
		
	}
}