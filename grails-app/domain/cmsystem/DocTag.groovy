package cmsystem

class DocTag {

	static belongsTo = [tag: Tag, document: Document]

    static constraints = {
    }

    static mapping = {
    	table 'DocTag'
    }
}
