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
		/*password blank: false, password: true, size:128, validator: {password, obj ->
			password = obj.password

			password == password ?: ['invalid.matchingpasswords']
		}
		
		salt blank: false, size:16, validator: {salt, obj ->
			salt = obj.salt
		}*/
    }

    static mapping = {
    	table '`User`'
    }
}
