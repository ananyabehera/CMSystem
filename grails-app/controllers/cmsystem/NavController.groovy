package cmsystem

class NavController {

     def index() { 
		render(view: 'index')
	}
	 
	 def documentUploadForm() {
		 [tagInstanceList: Tag.list()]
	 }
	 
	 def documentDetails() {
		 def documentInstance = Document.findById(params.id)
		 [documentInstance: Document.load(params.id) , docTagInstance: DocTag.findAllWhere(document: documentInstance)]
	 }
	 
	 def documentLibrary() {
        [documentInstanceList: Document.list(), documentInstanceTotal: Document.count()]
	}
	
	def editDocumentForm() {
		[documentInstance: Document.load(params.id), tagInstanceList: Tag.list()]
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
	 
	 def catgLibrary() {
		 [catgInstanceList: Category.list(), catgInstanceTotal: Category.count()]
	 }
 
	 def renderCategoryForm() {
		 render(view: "categoryCreateForm")
	 }
 
	 def catgEditForm() {
		 [catgInstance: Category.load(params.id)]
	 }
 
	 def catgDetails() {
		 [catgInstance: Category.load(params.id)]
	 }
	 
	 
}
