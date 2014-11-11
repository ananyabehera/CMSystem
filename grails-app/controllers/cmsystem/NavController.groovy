package cmsystem

import grails.converters.JSON

class NavController {

	def docController = new DocumentController()
	def catgController = new CategoryController()
	def tagController = new TagController()
	def userController = new UserAccountController()
	def authController = new AuthController()
	
     def index() { 
		render(view: 'index')
	 }
	 
	 def landingPage() {
		 if(session.user == null) {
			 if(authController.login()) { 
				 render(view: 'landingPage')
			 }
		 } else {
		 	render(view: 'landingPage')
		 }
	 }
	 
	 def loginPage() {
		 if(authController.logout()) {
			 render(view: 'index')
		 }
	 }
	 
	 def createUserPage() {
		 [permissionInstanceList: Permission.list()]
	 }
	 
	 def createUser() {
		 if(userController.create()) {
			 render(view: 'landingPage')
		  }
	 }
	 
	 def editUserDetailsPage() {
		 def user = UserAccount.findById(params.id)
		 
		 [userInstance: UserAccount.load(user.id), permissionInstanceList: Permission.list()]
	 }
	 
	 def updateUserDetails() {
		 if(userController.update()) {
			 render(view: 'landingPage')
		 }
	 }
	 
	 def editPasswordPage() {
		 def user = UserAccount.findById(params.id)
		 
		 [userInstance: UserAccount.load(user.id)]
	 }
	 
	 def updatePassword() {
		 if(authController.changePassword()) {
			 render(view: 'landingPage')
		 }
	 }
	 
	 def deleteUser() {
		 if(userController.remove(params.id)) {
			render(view: 'landingPage')
		 }
	 }
	 	 
	 def userLibraryPage() {
		 userController.show()
	 }
	 
	 def createCategoryPage() {
		 render(view: 'createCategoryForm')
	 }
	 
	 def createCategory() {
		 if(catgController.create()) {
			 render(view: 'landingPage')
		  }
	 }
	 
	 def editCategoryPage() {
		 def catg = Category.findById(params.id)
		 
		 [catgInstance: Category.load(catg.id)]
	 }
	 
	 def updateCategory() {
		 if(catgController.update()) {
			 render(view: 'landingPage')
		 }
	 }
	 
	 def deleteCategory() {
		 def message = "Category has been deleted\n" + Category.findById(params.id)
		 
		 if(catgController.remove(params.id)) {
			render(view: 'landingPage')
		 }
	 }
	 
	 def categoryLibraryPage() {
		 catgController.show()
	 }
	 
	 def createTagPage() {
		 [catgInstanceList: Category.list()]
	 }
	 
	 def createTag() {
		 if(tagController.create()) {
			 render(view: 'landingPage')
		  }
	 }
	 
	 def editTagPage() {
		 def tag = Tag.findById(params.id)
		 
		 [tagInstance: Tag.load(tag.id), categoryInstanceList: Category.list()]
	 }
	 
	 def updateTag() {
		 if(tagController.update()) {
			 render(view: 'landingPage')
		 }
	 }
	 
	 def deleteTag() {
		 def message = "tag has been deleted\n" + Tag.findById(params.id)
		 
		 if(tagController.remove(params.id)) {
			render(view: 'landingPage')
		 }
	 }
	 
	 def tagLibraryPage() {
		 tagController.show()
	 }
	 
	 def documentUploadPage() {
		 [tagInstanceList: Tag.list()]
	 }
	 
	 def uploadDocument() {
		  if(docController.create()) { 
			render(view: 'landingPage')
		  }
	 }
	 
	 def editDocumentPage () {
		 def document = Document.findById(params.id)
		 
		 [documentInstance: Document.load(document.id), tagInstanceList: Tag.list()]
	 }
	 
	 def updateDocument() {
		 if(docController.update()) {
			 render(view: 'landingPage')
		 }
	 }
	 
	 def deleteDocument() {
		 def message = "Document has been deleted\n" + Document.findById(params.id)
		 
		 if(docController.remove(params.id)) {
			render(view: 'landingPage')
		 }
	 }
	 
	 def documentLibraryPage() {
		 docController.show()
	 }
	 
	 def userSearch() {
		 userAccountController.search()
	 }
}
