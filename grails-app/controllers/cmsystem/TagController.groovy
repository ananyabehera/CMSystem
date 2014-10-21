package cmsystem
import grails.converters.*

class TagController {

    def index() { }
	
	// opens the tag create form
	def renderTagForm() {
		render(view: "tagCreateForm")
	}
	
	// opens the tag edit form
	def tagEditForm() {
		[tagInstance: Tag.load(params.id)]
	}
	
	// opens details of a specific tag
	def tagDetails() {
		[tagInstance: Tag.load(params.id)]
	}
	
	// renders the tag list
	def renderListing() {
		//params.max = 10
		[tagInstanceList: Tag.list(), tagInstanceTotal: Tag.count()]
	}
	
	// creates a new tag
	def createTag () {
		def tag = new Tag(params)
		tag.save()
		
		flash.message = "Tag created."
		redirect(controller: "AdminHome", action: "renderHomePage")
	}
	
	// updates an editable tag
	def updateTag() {
		def tag = Tag.findById(params.id)
		
		if(tag) {
			tag.tagName = params.tagName
			tag.dateUpdated = new Date()
			tag.tagDesc = params.tagDesc
			tag.save()
			flash.message = "Tag updated."
			redirect(controller: "Tag", action: "renderListing")
		}
	}
	
	// deletes a tag
	def deleteTag() {	
		def tag = Tag.findById(params.id)
		
		if(tag) {
			tag.delete(flush: true)
			redirect(controller: "Tag", action: "renderListing")
		}
	}
}
