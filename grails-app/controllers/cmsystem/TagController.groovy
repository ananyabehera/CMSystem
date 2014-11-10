package cmsystem
import grails.converters.*

class TagController {

	//static allowedMethods = [save: "POST", update: "POST", delete:  "DELETE"]
	def AuthController authController = new AuthController()

    def index() { }
	
	def show = {
		if(authController.sessionActive()) {
			if(params.id && Tag.exists(params.id)) {
				render Tag.findById(params.id) as JSON
			} else {
				render Tag.list() as JSON
			}
		}
		
	}
	
	def create =  {
		if(authController.sessionActive() && authController.adminAccess()) {
			def tag = new Tag()
			tag.tagDesc = params.tagDesc
			def existingCatg = Category.findById(params.category)
			tag.category = existingCatg
			tag.tagName = params.tagName
		
			if(tag.save()) {
				render(status: 201, text: '201: Created') as JSON
			} else {
				// Error handling section
				render(status: 400, text: '400: Bad Request') as JSON
			}
		}
	}
	
	// updates an editable tag
	def update = {
		if(authController.sessionActive() && authController.adminAccess()) {
			def tag = Tag.findById(params.id)
		
			if(tag) {
				def existingCatg = Category.findById(params.category)
				tag.category = existingCatg
				tag.tagName = params.tagName
				tag.dateUpdated = new Date()
				tag.tagDesc = params.tagDesc
				
				if(tag.save()) {
					render tag as JSON
				} else {
					//error handling code
					render(status: 400, text: '400: Bad Request') as JSON
				}
			}
		}
	}
	
	def remove = {
		if(authController.sessionActive() && authController.adminAccess()) {
			if(params.id && Tag.exists(params.id)) {
				Tag.load(params.id).delete(flush: true)
				render(status: 200, text: "200: OK") as JSON
			} else {
				// Error handling section
				render(status: 400, text: "400: Bad Request")
			}
		}
	}
}