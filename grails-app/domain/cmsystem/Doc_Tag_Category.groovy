package cmsystem

class Doc_Tag_Category {
	
	static belongsTo = [document:Document, tag:Tag, category:Category]
	
    static constraints = {
    }
	
	static mapping = {
		table 'Doc_Tag_Category'
	}
}
