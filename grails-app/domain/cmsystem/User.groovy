package cmsystem

class User {

	String firstName
	String lastName
	String userName
	String password
	Permission level
	
    static constraints = {
		password size: 1..128
    }

    static mapping = {
    	table '`User`'
    }
}
