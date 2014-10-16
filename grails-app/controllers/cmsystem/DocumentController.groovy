package cmsystem

import org.springframework.web.multipart.commons.CommonsMultipartFile

class DocumentController {

	private static final okcontents = ['pdf']
	
    def index() { }
	
	def renderUploadForm() {
		render(view: "documentUploadForm")
	}
	
	def renderHomePage() {
		if(session.user.level == "ADMIN")
		{
			render (view: "adminHome")
		}
		
		render(view: "index")
	}
	
	def upload_Doc() {
		
		def file = request.getFile('file')
		if(file.empty) {
			flash.message = "File cannot be empty"
		} else {
			def documentInstance = new Document()
			documentInstance.name = file.originalFilename
			documentInstance.fullPath = grailsApplication.config.uploadFolder + documentInstance.name
			file.transferTo(new File(documentInstance.fullPath))
			if(!documentInstance.save(flush: true))
				render "Error Occured"
		}
		
		flash.message = "Document uploaded."
		redirect(controller: "AdminHome", action: "renderHomePage")
		
		/*def doc = new Document()
		
		def CommonsMultipartFile uploadedFile = params.file
		
		log.info("File uploaded")
		if (!okcontents.contains(uploadedFile.getContentType())) {
			flash.message = "Document must be one of: ${okcontents}"
			render(view:'documentUploadForm')
			return
		}
		
		doc.file = uploadedFile.bytes
		doc.filetype = uploadedFile.contentType
		doc.name = params.name
		doc.uploadDate =params.date
		
		log.info("File uploaded")
		
		if (!doc.save(flush: true)) {
			flash.message = "Error Occured"
			render(view:'documentUploadForm')
			return
		  }
		
		  flash.message = "Docuemnt (${doc.filetype}, ${doc.file.size()} bytes) uploaded."
		  redirect(controller: "AdminHome", action: "renderHomePage")*/
		
		
	}
}
