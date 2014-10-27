package cmsystem

class DocTagCategory {
	
	static belongsTo = [document:Document, tag:Tag, category:Category]
	
    static constraints = {
    }
	
	static mapping = {
		table 'DocTagCategory'
	}
}
