package cmsystem

import grails.converters.JSON

class LandingPageController {

    //def auth = new AuthController()
	
	def renderHomePage() {
		//if(auth.sessionActive()) {
			render(view: "landingPage")
		//} 
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

	def createCategory() {
		redirect(controller: "Tag", action: "renderCategoryForm")
	}

	def listCategories() {
		redirect(controller: "Tag", action: "catgLibrary")
	}
}
