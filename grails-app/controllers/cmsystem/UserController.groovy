package cmsystem

import org.apache.commons.codec.digest.DigestUtils;

class UserController {

    def index() { 
		render(view: 'index')
	}
	
	// renders the user list
	def renderListing() {
		//params.max = 10
		[userInstanceList: User.list(), userInstanceTotal: User.count()]
	}
	
	def login() {
		def login = false
		def user = User.findByUserNameLike(params.userName)
		
		if(user.password == calculateHash(params.password)) {
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
		
		/*def login = false;	
		def user = User.findByUserNameAndPasswordAndSalt(params.userName, params.password,)
		
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
		}*/
		
	}
	
	def renderUserForm() {
		render(view: "createUserForm")
	}
	
	def createUser() {
		def userInstance = new User()
		def passwordHash
		
		if(User.findByUserNameLike(params.userName)) {
			flash.message = "- Username Already in use."
			render(view: "createUserForm")
		} else {
			userInstance.firstName = params.firstName.toLowerCase()
			userInstance.lastName = params.lastName.toLowerCase()
			userInstance.userName = params.userName.toLowerCase()
			userInstance.password = params.password
			userInstance.level = params.level
			
			passwordHash = calculateHash(userInstance.password)
			userInstance.password = passwordHash
			
			userInstance.save(flush: true)
			
			flash.message = "User created."
			redirect(controller: "AdminHome", action: "renderHomePage")
		}	
	}
	
	/*
	 * Currently not implemented as transient data wont work correctly - may implement later on
	 * def randomSalt () {
		def String salt = 0
		def random = new Random()
		
		
		for(int i = 0; i < 16; i++)
		{
			salt = salt + random.nextInt(10)
		}
		
		return salt
	}*/
	
	def calculateHash(String password) {
		return DigestUtils.sha512Hex(password);
	}
	
	def deleteUser() {
		def user = User.findById(params.id)
		
		if(user) {
			user.delete(flush: true)
			redirect(controller: "User", action: "renderListing")
		}
	}
	
	def logout() {
		session.user = null
		redirect(action: 'index')
	}
}
