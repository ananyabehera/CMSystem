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

			if(user.level == Permission.ADMIN)
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
	
	def renderUserForm() {
		render(view: "createUserForm")
	}
	
	def createUser() {
		def user = new User(params)
		user.save()
		
		flash.message = "User created."
		
		if (params.permissions == 'ADMIN')
			redirect(controller: "AdminHome", action: "renderHomePage")
		else
			redirect(controller: "GeneralHome", action: "renderHomePage")
	}
	
	def logout() {
		session.user = null
		redirect(action: 'index')
	}
}
