package cmsystem

import org.apache.commons.codec.digest.DigestUtils;

class UserAccountController {

    def index() { 
		render(view: 'index')
	}
	
	// renders the user list
	def userLibrary() {
		//params.max = 10
		[userInstanceList: UserAccount.list(), userInstanceTotal: UserAccount.count()]
	}
	
	def login() {
		def login = false
		def user = UserAccount.findByUsernameLike(params.username.toLowerCase())
		
		if(user != null) {
		
			if(user.password == calculateHash(params.password)) {
				session.user = user
				session.login = false
			
				redirect(controller: "LandingPage", action: "renderHomePage")
			} else {
				flash.message = "Login Failed: Incorrect password entered."
				session.login = true

				redirect(action: 'index')
			}
		} else {
			flash.message = "Login Failed: Account does not exist."
			
			redirect(action: 'index')
		}
	}
	
	def createUserForm() {
		[permissionInstanceList: Permission.list(), permissionInstanceTotal: Permission.count()]
	}
	
	def createUser() {
		def userInstance = new UserAccount()
		def permission = Permission.findById(params.permission)
		def passwordHash
		
		if(UserAccount.findByUsernameLike(params.username)) {
			flash.message = "- Username Already in use."
			render(view: "createUserForm")
		} else {
			userInstance.firstName = params.firstName.toLowerCase()
			userInstance.lastName = params.lastName.toLowerCase()
			userInstance.username = params.username.toLowerCase()
			userInstance.password = params.password
			userInstance.permission = permission
			
			passwordHash = calculateHash(userInstance.password)
			userInstance.password = passwordHash
			
			userInstance.save(flush: true)
			
			flash.message = "User created."
			redirect(controller: "LandingPage", action: "renderHomePage")
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
		def user = UserAccount.findById(params.id)
		
		if(user) {
			user.delete(flush: true)
			redirect(controller: "UserAccount", action: "userLibrary")
		}
	}
	
	def logout() {
		session.user = null
		redirect(action: 'index')
	}
}
