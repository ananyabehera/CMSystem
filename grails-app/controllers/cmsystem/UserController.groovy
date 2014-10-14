package cmsystem

class UserController {

    def index() { }
	
	def login() {
		def user = User.findByUserNameAndPassword(params.userName, params.password)
		if(user) {
			flash.message = "Login Succeeded"
			session.user = user
		}
		else {
			flash.message = "Login Failed"
		}
		
		redirect(action: 'index')
	}
	
	def logout() {
		session.user = null
		redirect(action: 'index')
	}
}
