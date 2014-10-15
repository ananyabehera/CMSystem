package cmsystem

class UserController {

    def index() { }
	
	def login() {
		def login = false;
		
		def user = User.findByUserNameAndPassword(params.userName, params.password)
		
		if(user) {
			flash.message = "Login Succeeded"
			session.user = user
			session.login = false
		}
		else {
			flash.message = "Login Failed"
			session.login = true
		}
		
		redirect(controller: 'User', action: 'index')
	}
	
	def logout() {
		session.user = null
		redirect(action: 'index')
	}
}
