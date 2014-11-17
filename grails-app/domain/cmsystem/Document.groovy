/**
 Domain model class which defines the structure of Document data.

 @authors Ananya Behera and Christian Sesta
 @version 5.1
 @datemodified 10th November 2014
*/

package cmsystem

class Document {
	
	String documentName
	String documentDesc
	Date dateUploaded = new Date()
	byte[] file
	String fileType
	
	static searchable = true

	
	/**
		Defines the relationships between the different database tables.  The subsequent lines of code state that:
		a) Every document belongs to a UserAccount
		b) Each document has many DocTags and many DocCategory associations
	*/
	static belongsTo = [userAccount:UserAccount]
	static hasMany = [docTags:DocTag, docCategories:DocCategory]
	
    static constraints = {
		documentName blank: false,
			nullable: false,
			size: 1..100
		
		documentDesc size: 1..1000
		
		file nullable:false,
			maxSize:1073741824
    }

    /**
		Ensures that the Document domain class is linked to the 'Document' table in the database
    */
    static mapping = {
    	table 'Document'
    }
}
