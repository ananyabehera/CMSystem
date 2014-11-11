package cmsystem

class UserAccount {
	
	String firstName
	String lastName
	String username
	String password
	
	static belongsTo = [permission:Permission]
	static hasMany = [documents:Document]
	
	static searchable = true
	
    static constraints = {
		firstName size: 1..50
		lastName size: 1..50
		username size: 1..20
		password size: 1..128
    }

    static mapping = {
    	table 'UserAccount'
    }
}
