package cmsystem

class Document {
	
	String docName
	String docDesc
	Date dateUploaded = new Date()
	byte[] file
	String fileType
	
	static belongsTo = [userAccount:UserAccount]
	static hasMany = [docTags:DocTag, docCategories:DocCategory]
	
    static constraints = {
		docName blank: false,
			nullable: false,
			size: 1..100
		
		docDesc size: 1..1000
		
		file nullable:false,
			maxSize:1073741824
			
		fileType size: 1..5
    }

    static mapping = {
    	table 'Document'
    }
}
