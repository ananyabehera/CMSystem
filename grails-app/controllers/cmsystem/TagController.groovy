/**
	Tag Controller class to enable RESTful API method calls.

	@authors Ananya Behera and Christian Sesta
	@version 6.3
	@datemodified 10th November 2014
*/

package cmsystem
import grails.converters.*

class TagController {

	//static allowedMethods = [save: "POST", update: "POST", delete:  "DELETE"]

	/**
		The AuthController attribute allows for session management and method availability based on permission
		levels.
	*/
	def AuthController authController = new AuthController()

    def index() { }
	/**
		The "show" method corresponds to the GET HTTP request and returns a list of Tags existing in the database 
		when an id is not specified, else it renders the specific desired tag.  Tag details are rendered in JSON format.

		@argument If an id is passed as an argument, the tag details of the corresponding Tag are returned.
		@precondition None
		@postcondition None
		@return JSON formatted details of the desired tag or tags 
	*/
	def show = {
		if(authController.sessionActive()) {
			if(params.id && Tag.exists(params.id)) {
				render Tag.findById(params.id) as JSON
			} else {
				render Tag.list() as JSON
			}
		}
		
	}
	/**
		The "create" method corresponds to the POST HTTP request and persists form data related to the creation of 
		a new Tag into the database.  If successful, a 201 message is returned, else a 400 error.

		@argument The form data passes as fields within the 'params' argument.
		@precondition At least 1 Category must have been added to the database as per functional requirements.
		@postcondition A new tag is created and added to the list of existing tags in the database.
		@return Status message depending on whether the save was successful or not 
	*/
	def create =  {
		if(authController.sessionActive() && authController.adminAccess()) {
			def tag = new Tag()
			
			tag.tagDesc = params.tagDesc
			tag.category = Category.findById(params.category)
			tag.tagName = params.tagName
		
			if(tag.save()) {
				//render(status: 201, text: '201: Created') as JSON
				render tag as JSON
			} else {
				// Error handling section
				render(status: 400, text: '400: Bad Request') as JSON
			}
		}
	}
	
	/**
		The "update" method corresponds to the POST HTTP request and updates an editable tag in the database.
		If successful, a 200 message is returned, else a 400 error.

		@argument The form data passes as fields within the 'params' argument.
		@precondition Atleast 1 Category must have been added to the database as per functional requirements.
		@postcondition The existing tag is updated with new data and saved to the database
		@return Status message depending on whether the save was successful or not 
	*/
	def update = {
		if(authController.sessionActive() && authController.adminAccess()) {
			if(params.id && Tag.exists(params.id)) {
				def tag = Tag.findById(params.id)
				
				tag.category = Category.findById(params.category)
				tag.tagName = params.tagName
				tag.dateUpdated = new Date()
				tag.tagDesc = params.tagDesc
				
				if(tag.save()) {
					//render(status: 200, text: '200: OK') as JSON
					render tag as JSON
				} else {
					//error handling code
					render(status: 400, text: '400: Bad Request') as JSON
				}
			}
		}
	}
	
	/**
		The "remove" method corresponds to the DELETE HTTP request and removes the desired tag from the database.
		Scaffold deleting features ensure that all bridging classes are updated accordingly
		
		@argument The id of the Tag to be deleted must be specified.
		@precondition The tag to be removed must be already present in the database.
		@postcondition The tag is removed from the database and associated tables are also updated.
		@return Status message depending on whether the save was successful or not 
	*/
	def remove = {
		if(authController.sessionActive() && authController.adminAccess()) {
			if(params.id && Tag.exists(params.id)) {
				Tag.load(params.id).delete(flush: true)
				//render(status: 200, text: "200: OK") as JSON
				return true
			} else {
				// Error handling section
				render(status: 404, text: "404: Not Found")
			}
		}
	}
}