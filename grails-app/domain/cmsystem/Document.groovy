package cmsystem

class Document {
	
	String name
	Date uploadDate = new Date()
	String desc
	byte[] file
	String type
	
    static constraints = {
		name(blank:false,nullable:false)
		file(nullable:false, maxSize:1073741824)
        //fullPath(blank:false,nullable:false)
    }

    static mapping = {
    	table 'document'
    }
}
