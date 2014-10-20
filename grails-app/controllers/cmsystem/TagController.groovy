package cmsystem

class TagController {

    def index() { }
	
	def renderTagForm() {
		render(view: "tagCreateForm")
	}
	
	def createTag () {
		def tag = new Tag(params)
		tag.save()
		
		flash.message = "Tag created."
		redirect(controller: "AdminHome", action: "renderHomePage")
	}
	
	def editTag() {
		def tag = Tag.findById(params.id)
		
		if(tag)
		{
			[tagInstanceList: Tag.load(tag)]
		}
	}
	
	def deleteTag() {	
		def tag = Tag.findById(params.id)
		
		if(tag)
		{
			tag.delete(flush: true)
			redirect(controller: "Tag", action: "renderListing")
		}
	}
	
	def renderListing() {
		//params.max = 10
		[tagInstanceList: Tag.list(), tagInstanceTotal: Tag.count()]
	}
}
