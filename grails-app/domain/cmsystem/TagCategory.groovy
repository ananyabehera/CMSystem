package cmsystem

class TagCategory {
	
	static belongsTo = [tag:Tag, category:Category]
	
    static constraints = {
    }
	
	static mapping = {
		table 'TagCategory'
	}
}
