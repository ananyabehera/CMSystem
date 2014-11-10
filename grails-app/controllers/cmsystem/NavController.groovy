package cmsystem

class NavController {

     def index() { 
		render(view: 'index')
	}
	 
	 /* def documentUploadForm() {
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
	}*/
}
