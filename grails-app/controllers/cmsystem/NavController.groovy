package cmsystem

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
		 if(authController.login()) { 
			render(view: 'landingPage')
		 }
	 }
	 
	 def loginPage() {
		 if(authController.logout())
		 {
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
	 
	 def documentLibraryPage() {
		 docController.show()
	 }
	 
	 def userSearch() {
		 userAccountController.search()
	 }
}
