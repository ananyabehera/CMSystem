package cmsystem

class User {

	String firstName
	String lastName
	String userName
	String password
	Permission level
	
    static constraints = {
    }

    static mapping = {
    	table '`User`'
    }
}
