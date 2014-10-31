package cmsystem

class Tag {

	String tagName
	String tagDesc
	Date dateCreated = new Date()
	Date dateUpdated = new Date()
	
	static belongsTo = [category:Category]
	static hasMany = [docTags:DocTag]
	
    static constraints = {
		tagName size: 1..100
		tagDesc size: 1..1000
    }
	
	static mapping = {
		table 'Tag'
	}
}
