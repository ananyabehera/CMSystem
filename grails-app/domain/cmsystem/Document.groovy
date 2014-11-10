package cmsystem

class Document {
	
	String documentName
	String documentDesc
	Date dateUploaded = new Date()
	byte[] file
	String fileType
	
	static belongsTo = [userAccount:UserAccount]
	static hasMany = [docTags:DocTag, docCategories:DocCategory]
	
    static constraints = {
		documentName blank: false,
			nullable: false,
			size: 1..100
		
		documentDesc size: 1..1000
		
		file nullable:false,
			maxSize:1073741824
			
		fileType size: 1..5
    }

    static mapping = {
    	table 'Document'
    }
}
