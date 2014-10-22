package cmsystem

class GeneralHomeController {

    def index() { }
	
	def renderHomePage() {
		render(view: "generalHome")
	}
	
	def listDocs() {
		redirect(controller: "Document", action: "renderListing")
	}

	def listTags() {
		redirect(controller: "Tag", action: "renderListing")
	}
}	
