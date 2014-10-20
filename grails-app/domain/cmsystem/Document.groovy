package cmsystem

class Document {
	
	String name
	Date uploadDate = new Date()
	//String fullPath
	byte[] file
	
    static constraints = {
		name(blank:false,nullable:false)
        //fullPath(blank:false,nullable:false)
    }
}
