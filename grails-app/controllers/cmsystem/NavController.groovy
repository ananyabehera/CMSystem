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
}
