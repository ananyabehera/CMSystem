package cmsystem

import grails.converters.*

class UserAccountController {
	
	def authController = new AuthController()

    def index() { 
		render(view: 'index')
	}
	
	def show = {
		if(params.id && UserAccount.exists(params.id)) {
			render UserAccount.findById(params.id) as JSON
		} else {
			render UserAccount.list() as JSON
		}
	}
	
	def save = {
		def user = new UserAccount(params['user'])
		
		if(user.save()) {
			render user as JSON
		} else {
			// Error handling section
		}
	}
	
	def update = {
		
	}
	
	def remove = {
		if(params.id && UserAccount.exists(params.id)){
			UserAccount.load(params.id).delete(flush: true)
			render(status: 200, text: "200: OK") as JSON
		} else {
			// Error handling section
			render(status: 400, text: "400: Bad Request")
		}
	}
	
	// renders the user list
	/*def userLibrary() {
		//params.max = 10
		[userInstanceList: UserAccount.list(), userInstanceTotal: UserAccount.count()]
	}*/
	
	
	
	/*def createUserForm() {
		[permissionInstanceList: Permission.list(), permissionInstanceTotal: Permission.count()]
	}*/
	
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
			
			passwordHash = authController.calculateHash(userInstance.password)
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
	
	
	
	def deleteUser() {
		def user = UserAccount.findById(params.id)
		
		if(user) {
			user.delete(flush: true)
			redirect(controller: "UserAccount", action: "userLibrary")
		}
	}
}
