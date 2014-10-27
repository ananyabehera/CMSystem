package cmsystem

class LandingPageController {

    def index() { }
	
	def renderHomePage() {
		render(view: "landingPage")
	}
	
	def uploadDoc() {
		redirect(controller: "Document", action: "documentUploadForm")
	}

	def listDocs() {
		redirect(controller: "Document", action: "documentLibrary")
	}

	def createTag() {
		redirect(controller: "Tag", action: "renderTagForm")
	}
	
	def listTags() {
		redirect(controller: "Tag", action: "tagLibrary")	
	}
	
	def createUser() {
		redirect(controller: "UserAccount", action: "createUserForm")
	}
	
	def listUsers() {
		redirect(controller: "UserAccount", action: "userLibrary")
	}
}
