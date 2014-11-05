package cmsystem
import grails.converters.*

class TagController {

    def index() { }
	
	// opens the tag create form
	def renderTagForm() {
		[catgInstanceList: Category.list()]
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
	def tagLibrary() {
		//params.max = 10
		[tagInstanceList: Tag.list(), tagInstanceTotal: Tag.count()]
	}

	/*def catgLibrary() {
		[catgInstanceList: Category.list(), catgInstanceTotal: Category.count()]
	} */

	def renderCategoryForm() {
		render(view: "categoryCreateForm")
	}

	/*def catgEditForm() {
		[catgInstance: Category.load(params.id)]
	}

	def catgDetails() {
		[catgInstance: Category.load(params.id)]
	}*/
	
	// creates a new tag
	def createTag () {
		def tag = new Tag()
		//tag.tagName = params.tagName
		tag.tagDesc = params.tagDesc
		def existingCatg = Category.findById(params.category)
		tag.category = existingCatg
		tag.tagName = existingCatg.catgName + ": " + params.tagName
		def theNewTag = tag.save()
		
		flash.message = "Tag created."
		redirect(controller: "LandingPage", action: "renderHomePage")
	}

	/*def createCategory () {
		def catg = new Category(params)
		catg.save()

		flash.message = "Category Created."
		redirect(controller: "LandingPage", action: "renderHomePage")
	}*/
	
	// updates an editable tag
	def updateTag() {
		def tag = Tag.findById(params.id)
		
		if(tag) {
			tag.tagName = params.tagName
			tag.dateUpdated = new Date()
			tag.tagDesc = params.tagDesc
			tag.save()
			flash.message = "Tag updated."
			redirect(controller: "Tag", action: "tagLibrary")
		}
	}

	def updateCatg() {
		def catg = Category.findById(params.id)

		if(catg)
		{
			catg.catgName = params.catgName
			catg.dateUpdated = new Date()
			catg.catgDesc = params.catgDesc
			catg.save()
			flash.message = "Category Updated"
			redirect(controller: "Tag", action: "catgLibrary")
		}
	}
	
	// deletes a tag
	def deleteTag() {	
		def tag = Tag.findById(params.id)
		
		if(tag) {
			tag.delete(flush: true)
			redirect(controller: "Tag", action: "tagLibrary")
		}
	}

	def deleteCatg() {
		def catg = Category.findById(params.id)

		if(catg) {
			catg.delete(flush: true)
			redirect(controller: "Tag", action: "catgLibrary")
		}
	}
}
