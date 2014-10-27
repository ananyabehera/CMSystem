package cmsystem

class DocTypeCategory {

	static belongsTo = [docType:DocType, category:Category]
	
    static constraints = {
    }
	
	static mapping = {
		table 'DocTypeCategory'
	}
}
