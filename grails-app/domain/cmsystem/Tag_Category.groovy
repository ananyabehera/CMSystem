package cmsystem

class Tag_Category {
	
	static belongsTo = [tag:Tag, category:Category]
	
    static constraints = {
    }
	
	static mapping = {
		table 'Tag_Category'
	}
}
