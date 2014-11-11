/**
	User Account Controller class to enable RESTful API method calls.

	@authors Ananya Behera and Christian Sesta
	@version 11.6
	@datemodified 10th November 2014
*/

package cmsystem

import grails.converters.JSON

class UserAccountController {
	
	/**
		The AuthController attribute allows for session management and method availability based on permission
		levels.
	*/
	def AuthController authController = new AuthController()
	
	/**
		The "show" method corresponds to the GET HTTP request and returns a list of Users existing in the database 
		when an id is not specified, else it renders the specific desired user.  User details are rendered in JSON format.

		@argument If an id is passed as an argument, the details of the corresponding User are returned.
		@precondition None
		@postcondition None
		@return JSON formatted details of the desired user or users
	*/
	def show = {
		if (authController.sessionActive() && authController.adminAccess()) {
			if(params.id && UserAccount.exists(params.id)) {
				render UserAccount.findById(params.id) as JSON
			} else {
				render UserAccount.list() as JSON
			}
		}	
	}


	/**
		The "create" method corresponds to the POST HTTP request and persists form data related to the creation of 
		a new User into the database.  If successful, a 201 message is returned, else a 400 error.

		@argument The form data passes as fields within the 'params' argument.
		@precondition A user with Administrator privileges must be logged into the system to create a new user.
		@postcondition A new user is created and added to the list of existing users in the database.
		@return Status message depending on whether the save was successful or not 
	*/
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
					//render(status: 201, text: '201: Created') as JSON
					return true
				} else {
					// Error handling section
					render(status: 400, text: '400: Bad Request') as JSON
				}
			}
		}
	}
	
	
	def search = {
		if (authController.sessionActive()) {
			// Below 2 lines cause duplicate results to be displayed. Not to sure how to fix, need a select by distinct? 
			// or attempt an executeQuery on the domain class? :'C 
			def searchResults = UserAccount.findAllByFirstNameIlike("%"+params.search+"%")
			searchResults += UserAccount.findAllByLastNameIlike("%"+params.search+"%")
				
			if(searchResults.size() > 0) {
				//render(status: 200, text: '200: OK') as JSON
				render searchResults as JSON
			} else {
				// Error handling section
				render(status: 400, text: '400: Bad Request') as JSON
			}
		}
	}

	/**
		The "update" method corresponds to the POST HTTP request and updates an editable user in the database.
		If successful, a 200 message is returned, else a 400 error.

		@argument The form data passes as fields within the 'params' argument.
		@precondition None
		@postcondition The existing user is updated with new data and saved to the database
		@return Status message depending on whether the save was successful or not 
	*/
	def update = {
		if (authController.sessionActive()) {
			if(params.id && UserAccount.exists(params.id)) {
				def user = UserAccount.findById(params.id)
				def permission = Permission.findById(params.permission)
				
				user.firstName = params.firstName.toLowerCase()
				user.lastName = params.lastName.toLowerCase()
				user.permission = permission
				
				if(user.save(flush: true)) {
					//render(status: 200, text: '200: OK') as JSON
					return true
				} else {
					// Error handling section
					render(status: 400, text: '400: Bad Request') as JSON
				}
			} else {
				render(status: 404, text: '404: Not Found') as JSON
			}
		}
	}
	

	/**
		This method enables the logged in User to change their password.
		
		@argument None
		@precondition None
		@postcondition The user password is updated in the database.
		@return Status message depending on whether the update was successful or not 
	*/
	def changePassword = {
		if (authController.sessionActive()) {
			def user = UserAccount.findById(session.user.id)
			
			if(params.password == params.passwordConfirmation) {
				user.password = authController.calculateHash(params.password)
				//render(status: 200, text: '200: OK') as JSON
				return true
			} else {
				render(status: 409, text: '409: Conflict') as JSON
			}
		}
	}
	
	/**
		The "remove" method corresponds to the DELETE HTTP request and removes the desired user from the database.
		Scaffold deleting features ensure that all bridging classes are updated accordingly
		
		@argument The id of the User to be deleted must be specified.
		@precondition The user to be removed must be already present in the database.
		@postcondition The user is removed from the database and associated tables are also updated.
		@return Status message depending on whether the delete was successful or not 
	*/
	def remove = {
		if (authController.sessionActive() && authController.adminAccess())
		{
			if(params.id && UserAccount.exists(params.id)) {
				if(UserAccount.load(params.id).delete(flush: true)) {
					//render(status: 200, text: "200: OK") as JSON
					return true
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