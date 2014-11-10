package cmsystem
import grails.converters.*

class CategoryController {

	def AuthController authController = new AuthController()

    def index() { }
	
	def show = {
		if(authController.sessionActive()) {
			if(params.id && Category.exists(params.id)) {
				render Category.findById(params.id) as JSON
			} else {
				render Category.list() as JSON
			}
		}
	}
	
	def create =  {
		if(authController.sessionActive() && authController.adminAccess()) {
			def catg = new Category()
			catg.catgDesc = params.catgDesc
			catg.catgName = params.catgName
		
			if(catg.save()) {
				render(status: 201, text: '201: Created') as JSON
			} else {
				// Error handling section
				render(status: 400, text: '400: Bad Request') as JSON
			}
		}
	}

	def update = {
		if(authController.sessionActive() && authController.adminAccess()) {
			def catg = Category.findById(params.id)

			if(catg) {	
				catg.catgName = params.catgName
				catg.dateUpdated = new Date()
				catg.catgDesc = params.catgDesc
				
				if(catg.save()) {
					render catg as JSON
				} else {
					//error handling code
					render(status: 400, text: '400: Bad Request') as JSON
				}
			}
		}
	}

	def remove = {
		if(authController.sessionActive() && authController.adminAccess()) {
			if(params.id && Category.exists(params.id)) {
				Category.load(params.id).delete(flush: true)
				render(status: 200, text: "200: OK") as JSON
			} else {
				// Error handling section
				render(status: 400, text: "400: Bad Request")
			}
		}
	}
}
