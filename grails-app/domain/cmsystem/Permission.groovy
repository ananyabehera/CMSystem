package cmsystem

class Permission {
	String pType
	
	static hasMany = [userAccounts:UserAccount]
	
    static constraints = {
		pType size: 1..30
    }
	
	static mapping = {
		table 'Permission'
	}
}
