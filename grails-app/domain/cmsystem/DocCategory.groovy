package cmsystem

class DocCategory {
	
	static belongsTo = [document:Document, category:Category]

    static constraints = {
    }
	
	static mapping = {
		table 'DocCategory'
	}
}
