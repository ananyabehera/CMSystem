package cmsystem

class User {

	String firstName
	String lastName
	String userName
	String password
	String  salt
	Permission level
	
	static transients = ['password', 'salt']
	
    static constraints = {
		password bindable: true,
			nullable: false
		
		salt bindable: true,
			nullable: false
    }

    static mapping = {
    	table '`User`'
    }
}
