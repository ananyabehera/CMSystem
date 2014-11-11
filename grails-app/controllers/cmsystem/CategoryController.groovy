/**
	Category Controller class to enable RESTful API method calls.

	@authors Ananya Behera and Christian Sesta
	@version 4.4
	@datemodified 10th November 2014
*/

package cmsystem
import grails.converters.*

class CategoryController {


	/**
		The AuthController attribute allows for session management and method availability based on permission
		levels.
	*/
	def AuthController authController = new AuthController()
	
	/**
		The "show" method corresponds to the GET HTTP request and returns a list of Categories existing in the database 
		when an id is not specified, else it renders the specific desired category. Tag details are rendered in JSON format.

		@argument If an id is passed as an argument, the tag details of the corresponding Tag are returned.
		@precondition None
		@postcondition None
		@return JSON formatted details of the desired category or categories
	*/
	def show = {
		if(authController.sessionActive()) {
			if(params.id && Category.exists(params.id)) {
				render Category.findById(params.id) as JSON
			} else {
				render Category.list() as JSON
			}
		}
	}
	
	/**
		The "create" method corresponds to the POST HTTP request and persists form data related to the creation of 
		a new Category into the database.  If successful, a 201 message is returned, else a 400 error.

		@argument The form data passes as fields within the 'params' argument.
		@precondition None
		@postcondition A new category is created and added to the list of existing categories in the database.
		@return Status message depending on whether the save was successful or not 
	*/
	def create =  {
		if(authController.sessionActive() && authController.adminAccess()) {
			def catg = new Category()
			catg.catgDesc = params.catgDesc
			catg.catgName = params.catgName
		
			if(catg.save()) {
				//render(status: 201, text: '201: Created') as JSON
				return true
			} else {
				// Error handling section
				render(status: 400, text: '400: Bad Request') as JSON
			}
		}
	}

	/**
		The "update" method corresponds to the POST HTTP request and updates an editable category in the database.
		If successful, a 200 message is returned, else a 400 error.

		@argument The form data passes as fields within the 'params' argument.
		@precondition None
		@postcondition The existing category is updated with new data and saved to the database
		@return Status message depending on whether the save was successful or not 
	*/
	def update = {
		if(authController.sessionActive() && authController.adminAccess()) {
			if(params.id && Category.exists(params.id)) {	
				def catg = Category.findById(params.id)
				
				catg.catgName = params.catgName
				catg.dateUpdated = new Date()
				catg.catgDesc = params.catgDesc
				
				if(catg.save()) {
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
		The "remove" method corresponds to the DELETE HTTP request and removes the desired category from the database.
		Scaffold deleting features ensure that all bridging classes are updated accordingly
		
		@argument The id of the Category to be deleted must be specified.
		@precondition The category to be removed must be already present in the database.
		@postcondition The category is removed from the database and associated tables are also updated.
		@return Status message depending on whether the delete was successful or not 
	*/
	def remove = {
		if(authController.sessionActive() && authController.adminAccess()) {
			if(params.id && Category.exists(params.id)) {
				Category.load(params.id).delete(flush: true)
				//render(status: 200, text: "200: OK") as JSON
				return true
			} else {
				// Error handling section
				render(status: 400, text: "400: Bad Request")
			}
		}
	}
}
