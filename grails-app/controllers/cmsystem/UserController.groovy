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

			if(user.level == ADMIN)
				redirect(controller: "AdminHome", action: "renderHomePage")
			else
				redirect(controller: "GeneralHome", action: "renderHomePage")
		}
		else {
			flash.message = "Login Failed"
			session.login = true

			redirect(action: 'index')
		}
		
	}
	
	def logout() {
		session.user = null
		redirect(action: 'index')
	}
}
