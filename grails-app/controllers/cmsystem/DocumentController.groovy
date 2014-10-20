package cmsystem

import org.springframework.web.multipart.commons.CommonsMultipartFile
import org.codehaus.groovy.grails.web.context.ServletContextHolder
import grails.util.GrailsUtil

class DocumentController {

	boolean transactional = true
	
    def index() { }
	
	def documentUploadForm() {
		[tagInstanceList: Tag.list(), TagInstanceTotal: Tag.count()]
	}
	
	def upload_Doc() {

		
		def file = request.getFile('file')
		if(file.empty) {
			flash.message = "File cannot be empty"
		} else {
			def documentInstance = new Document()
			documentInstance.name = file.originalFilename
			documentInstance.file = file.bytes
			/*documentInstance.fullPath = grailsApplication.config.uploadFolder + documentInstance.name
			File dest = new File(documentInstance.fullPath)
			file.transferTo(dest)*/
			if(!documentInstance.save(flush: true))
				render "Error Occured"
		}
		
		flash.message = "Document uploaded."
		redirect(controller: "AdminHome", action: "renderHomePage")
		
	}

	def renderListing() {
		//params.max = 10
        [documentInstanceList: Document.list(), documentInstanceTotal: Document.count()]
	}

}
