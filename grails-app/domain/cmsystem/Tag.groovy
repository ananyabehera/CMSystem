package cmsystem

class Tag {

	String tagName
	String tagDesc
	Date dateCreated = new Date()
	Date dateUpdated = new Date()
	
	static hasMany = [tagCategories:TagCategory, docTagCategories:DocTagCategory]
	
    static constraints = {
		tagName size: 1..100
		tagDesc size: 1..1000
    }
	
	static mapping = {
		table 'Tag'
	}
}
