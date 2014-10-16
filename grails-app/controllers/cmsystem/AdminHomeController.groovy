package cmsystem

class AdminHomeController {

    def index() { }
	
	def renderHomePage() {
		render(view: "adminHome")
	}
	
	def uploadDoc() {
		redirect(controller: "Document", action: "renderUploadForm")
	}

	def listDocs() {
		redirect(controller: "Document", action: "renderListing")
	}
}
