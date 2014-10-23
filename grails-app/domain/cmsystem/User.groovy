package cmsystem

class User {

	String firstName
	String lastName
	String userName
	transient password
	transient  salt
	Permission level
	
	
	
    static constraints = {
		password size: 128
		salt size: 16
    }

    static mapping = {
    	table '`User`'
    }
}
