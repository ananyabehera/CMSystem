package cmsystem

class Category {
	
	String CatgName
	String catgDesc
	Date dateCreated
	Date dateUpdated
	
	static hasMany = [tagCategories:TagCategory, docTagCategories:DocTagCategory, docTypeCategories:DocTypeCategory]
	
    static constraints = {
		catgName size: 1..100
		catgDesc size: 1..1000
    }
	
	static mapping = {
		table 'Category'
	}
}
