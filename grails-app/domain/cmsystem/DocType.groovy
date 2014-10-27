package cmsystem

class DocType {

	String dType

	static hasMany = [documents:Document, docTypeCategories:DocTypeCategory]
	
    static constraints = {
		dType size: 1..30
    }
	
	static mapping = {
		table 'DocType'
	}
}
