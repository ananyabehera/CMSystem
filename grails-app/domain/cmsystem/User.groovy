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
		password size: 128,
				bindable: true
		
		salt size: 16,
			bindable: true
    }

    static mapping = {
    	table '`User`'
    }
}
