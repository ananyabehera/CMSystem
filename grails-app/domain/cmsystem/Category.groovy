package cmsystem

class Category {
	
	String catgName
	String catgDesc
	Date dateCreated = new Date()
	Date dateUpdated = new Date()
	
	static hasMany = [tagCategories:TagCategory, docTagCategories:DocTagCategory, docTypeCategories:DocTypeCategory]
	
    static constraints = {
		catgName size: 1..100
		catgDesc size: 1..1000
    }
	
	static mapping = {
		table 'Category'
	}
}
