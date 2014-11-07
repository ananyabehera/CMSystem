package cmsystem
import grails.converters.*

class TagController {

	//static allowedMethods = [save: "POST", update: "POST", delete:  "DELETE"]

    def index() { }
	
	def save = {
		def tag = new Tag(params['tag'])
		
		if(tag.save()) {
			render tag as JSON
		} else {
			// Error handling section
		}
	}

	def show = {
		if(params.id && Tag.exists(params.id))
		{
			render Tag.findById(params.id) as JSON
		}
		else
		{
			render Tag.list() as JSON
		}
	}
	
	// opens the tag create form
	def renderTagForm() {
		[catgInstanceList: Category.list()]
	}
	
	// opens the tag edit form
	def tagEditForm() {
		[tagInstance: Tag.load(params.id), categoryInstance: Category.list()]
	}
	
	// opens details of a specific tag
	def tagDetails() {
		[tagInstance: Tag.load(params.id)]
	}
	
	// renders the tag list
	def tagLibrary() {
		//params.max = 10
		[tagInstanceList: Tag.list(), tagInstanceTotal: Tag.count()]
	}
	
	// creates a new tag
	def createTag () {
		def tag = new Tag()
		//tag.tagName = params.tagName
		tag.tagDesc = params.tagDesc
		def existingCatg = Category.findById(params.category)
		tag.category = existingCatg
		tag.tagName = params.tagName
		def theNewTag = tag.save()
		
		flash.message = "Tag created."
		redirect(controller: "LandingPage", action: "renderHomePage")
	}
	
	// updates an editable tag
	def update = {
		def tag = Tag.findById(params.id)
		
		if(tag) {
			def existingCatg = Category.findById(params.category)
			tag.category = existingCatg
			tag.tagName = params.tagName
			tag.dateUpdated = new Date()
			tag.tagDesc = params.tagDesc
			if(tag.save())
			{
				render tag as JSON
			}
			else
			{
				//error handling code
			}
		}
	}
	
	// deletes a tag
	def delete =  {	

		if(params.id && Tag.exists(params.id))
		{
			Tag.load(params.id).delete(flush: true)
			render "Deleted 1 item"
		}
		//else
		//{
		//	render Tag.list() as JSON
		//}
	}
	
}
