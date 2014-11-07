package cmsystem

import grails.converters.*

class UserAccountController {
	
	def AuthController authController = new AuthController()

    def index() { 
		render(view: 'index')
	}
	
	def show = {
		if (authController.sessionActive()) {
			if(params.id && UserAccount.exists(params.id)) {
				render UserAccount.findById(params.id) as JSON
			} else {
				render UserAccount.list() as JSON
			}
		}
		
	}
	
	def create = {
		if (authController.sessionActive())
		{
			def user = new UserAccount(params['user'])
		
			if(user.save()) {
				render user as JSON
			} else {
				// Error handling section
			}
		}
	}
	
	def update = {
		
	}
	
	def remove = {
		if (authController.sessionActive())
		{
			if(params.id && UserAccount.exists(params.id)){
				UserAccount.load(params.id).delete(flush: true)
				render(status: 200, text: "200: OK") as JSON
			} else {
				// Error handling section
				render(status: 400, text: "400: Bad Request")
			}
		}
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
			
			passwordHash = authController.calculateHash(userInstance.password)
			userInstance.password = passwordHash
			
			userInstance.save(flush: true)
			
			flash.message = "User created."
			redirect(controller: "LandingPage", action: "renderHomePage")
		}	
	}
	
	def deleteUser() {
		def user = UserAccount.findById(params.id)
		
		if(user) {
			user.delete(flush: true)
			redirect(controller: "UserAccount", action: "userLibrary")
		}
	}
}
