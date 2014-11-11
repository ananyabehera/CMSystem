/**
	Biography Controller class to enable RESTful API method calls.

	@authors Ananya Behera and Christian Sesta
	@version 1.0
	@datemodified 12th November 2014
*/

package cmsystem
import grails.converters.*

class BiographyController {

	/**
		The AuthController attribute allows for session management and method availability based on permission
		levels.
	*/
	def AuthController authController = new AuthController()
	
	/**
		The "show" method corresponds to the GET HTTP request and returns a list of biographies existing in the database 
		when an id is not specified, else it renders the specific desired biography. Biography details are rendered in JSON format.

		@argument If an id is passed as an argument, the details of the corresponding Biography are returned.
		@precondition None
		@postcondition None
		@return JSON formatted details of the desired biography or biographies
	*/
	def show = {
		if(authController.sessionActive()) {
			if(params.id && Biography.exists(params.id)) {
				render Biography.findById(params.id) as JSON
			} else {
				render Biography.list() as JSON
			}
		}
	}
	
	/**
		The "create" method corresponds to the POST HTTP request and persists form data related to the creation of 
		a new Biography into the database.  If successful, a 201 message is returned, else a 400 error.

		@argument The form data passes as fields within the 'params' argument.
		@precondition None
		@postcondition A new biography is created and added to the list of existing biographies in the database.
		@return Status message depending on whether the save was successful or not 
	*/
	def create =  {
		if(authController.sessionActive() && authController.adminAccess()) {
			def bio = new Biography(params['bio'])
		
			if(bio.save()) {
				//render(status: 201, text: '201: Created') as JSON
				return true
			} else {
				// Error handling section
				render(status: 400, text: '400: Bad Request') as JSON
			}
		}
	}

	/**
		The "update" method corresponds to the POST HTTP request and updates an editable biography in the database.
		If successful, a 200 message is returned, else a 400 error.

		@argument The form data passes as fields within the 'params' argument.
		@precondition None
		@postcondition The existing biography is updated with new data and saved to the database
		@return Status message depending on whether the save was successful or not 
	*/
	def update = {
		if(authController.sessionActive() && authController.adminAccess()) {
			if(params.id && Biography.exists(params.id)) {	
				def bio = Biography.findById(params.id)
				
				bio.firstName = params.firstName
				bio.lastName = params.lastName
				bio.title = params.title
				bio.team = params.team
				bio.bioDesc = params.bioDesc
				bio.oneLiner = params.oneLiner
				bio.loveSentance = params.loveSentance
				
				if(bio.save()) {
					//render(status: 200, text: '200: OK') as JSON
					return true
				} else {
					//error handling code
					render(status: 400, text: '400: Bad Request') as JSON
				}
			}
		}
	}

	/**
		The "remove" method corresponds to the DELETE HTTP request and removes the desired biography from the database.
		Scaffold deleting features ensure that all bridging classes are updated accordingly
		
		@argument The id of the Biography to be deleted must be specified.
		@precondition The biography to be removed must be already present in the database.
		@postcondition The biography is removed from the database and associated tables are also updated.
		@return Status message depending on whether the delete was successful or not 
	*/
	def remove = {
		if(authController.sessionActive() && authController.adminAccess()) {
			if(params.id && Biography.exists(params.id)) {
				Biography.load(params.id).delete(flush: true)
				//render(status: 200, text: "200: OK") as JSON
				return true
			} else {
				// Error handling section
				render(status: 404, text: "404: Not Found")
			}
		}
	}
}

