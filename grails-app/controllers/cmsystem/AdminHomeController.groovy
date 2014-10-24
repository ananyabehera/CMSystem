package cmsystem

class AdminHomeController {

    def index() { }
	
	def renderHomePage() {
		render(view: "adminHome")
	}
	
	def uploadDoc() {
		redirect(controller: "Document", action: "documentUploadForm")
	}

	def listDocs() {
		redirect(controller: "Document", action: "renderListing")
	}

	def createTag() {
		redirect(controller: "Tag", action: "renderTagForm")
	}
	
	def listTags() {
		redirect(controller: "Tag", action: "renderListing")	
	}
	
	def createUser() {
		redirect(controller: "User", action: "renderUserForm")
	}
	
	def listUsers() {
		redirect(controller: "User", action: "renderListing")
	}
}
