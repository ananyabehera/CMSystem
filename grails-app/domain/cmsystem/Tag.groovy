package cmsystem

class Tag {

	String tagName
	String tagDesc
	Date dateCreated = new Date()
	Date dateUpdated = new Date()
	static belongsTo = Document
	static hasMany = [document:Document]
	
    static constraints = {
		tagName size: 1..50
		tagDesc size: 1..1000
    }
}
