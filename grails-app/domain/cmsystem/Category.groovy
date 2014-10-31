package cmsystem

class Category {
	
	String catgName
	String catgDesc
	Date dateCreated = new Date()
	Date dateUpdated = new Date()
	
	static hasMany = [tags:Tag, docCategories:DocCategory]
	
    static constraints = {
		catgName size: 1..100
		catgDesc size: 1..1000
    }
	
	static mapping = {
		table 'Category'
	}
}
