package cmsystem

import org.springframework.web.multipart.commons.CommonsMultipartFile

class DocumentController {

	private static final okcontents = ['pdf']
	
    def index() { }
	
	def renderUploadForm() {
		render(view: "documentUploadForm")
	}
	
	def upload_Doc() {
		
		def file = request.getFile('file')
		if(file.empty) {
			flash.message = "File cannot be empty"
		} else {
			def documentInstance = new Document()
			documentInstance.name = file.originalFilename
			documentInstance.fullPath = grailsApplication.config.uploadFolder + documentInstance.name
			File dest = new File(req.getServletContext().getResource(documentInstance.fullPath).toURI())
			file.transferTo(dest)
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
