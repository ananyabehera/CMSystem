package cmsystem

import grails.converters.JSON

class UserAccountController {
	
	def AuthController authController = new AuthController()
	
	def show = {
		if (authController.sessionActive() && authController.adminAccess()) {
			if(params.id && UserAccount.exists(params.id)) {
				render UserAccount.findById(params.id) as JSON
			} else {
				render UserAccount.list() as JSON
			}
		}	
	}
	
	def create = {
		if (authController.sessionActive() && authController.adminAccess()) {
			def user = new UserAccount()
			def permission = Permission.findById(params.permission)
			
			if(UserAccount.findByUsernameLike(params.username)) {
				render(status: 409, text: '409: Conflict') as JSON
			} else {
				user.firstName = params.firstName.toLowerCase()
				user.lastName = params.lastName.toLowerCase()
				user.username = params.username.toLowerCase()
				user.password = authController.calculateHash(params.password)
				user.permission = permission
				
				if(user.save(flush: true)) {
					render(status: 201, text: '201: Created') as JSON
				} else {
					// Error handling section
					render(status: 400, text: '400: Bad Request') as JSON
				}
			}
		}
	}
	
	def update = {
		if (authController.sessionActive()) {
			if(params.id && UserAccount.exists(params.id)) {
				def user = UserAccount.findById(params.id)
				def permission = Permission.findById(params.permission)
				
				user.firstName = params.firstName.toLowerCase()
				user.lastName = params.lastName.toLowerCase()
				user.permission = permission
				
				if(user.save(flush: true)) {
					render(status: 200, text: '200: OK') as JSON
				} else {
					// Error handling section
					render(status: 400, text: '400: Bad Request') as JSON
				}
			} else {
				render(status: 404, text: '404: Not Found') as JSON
			}
		}
	}
	
	def changePassword = {
		if (authController.sessionActive()) {
			def user = UserAccount.findById(session.user.id)
			
			if(params.password == params.passwordConfirmation) {
				user.password = authController.calculateHash(params.password)
				render(status: 200, text: '200: OK') as JSON
			} else {
				render(status: 409, text: '409: Conflict') as JSON
			}
		}
	}
	
	def remove = {
		if (authController.sessionActive() && authController.adminAccess())
		{
			if(params.id && UserAccount.exists(params.id)) {
				if(UserAccount.load(params.id).delete(flush: true)) {
					render(status: 200, text: "200: OK") as JSON
				} else {
				render(status: 400, text: '400: Bad Request') as JSON
				}
				
			} else {
				// Error handling section
				render(status: 404, text: "404: Not Found")
			}
		}
	}
}