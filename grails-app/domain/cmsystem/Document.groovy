package cmsystem

class Document {
	
	String name
	Date uploadDate = new Date()
	//String fullPath
	byte[] file
	
    static constraints = {
		name(blank:false,nullable:false)
		file(nullable:false, maxSize:1073741824)
        //fullPath(blank:false,nullable:false)
    }
}
