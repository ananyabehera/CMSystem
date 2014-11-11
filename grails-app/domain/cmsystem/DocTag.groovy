package cmsystem

class DocTag {

	static belongsTo = [tag: Tag, document: Document]

    static mapping = {
    	table 'DocTag'
    }
}
