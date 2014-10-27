package cmsystem

class Permission {
	String pType
	
	static hasMany = [users:User]
	
    static constraints = {
		pType size: 1..30
    }
	
	static mapping = {
		table 'Permission'
	}
}
