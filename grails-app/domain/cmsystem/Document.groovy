package cmsystem

class Document {
	
	String name
	Date uploadDate = new Date()
	String documentDescription
	byte[] file
	String type
	List tag
	
	static hasMany = [tag:Tag]
	
    static constraints = {
		name(blank:false,nullable:false)
		file(nullable:false, maxSize:1073741824)
        //fullPath(blank:false,nullable:false)
    }

    static mapping = {
    	table 'document'
    }
}
