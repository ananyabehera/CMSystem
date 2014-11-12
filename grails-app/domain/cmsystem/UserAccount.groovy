/**
	 Domain model class which defines the structure of UserAccount data.

	 @authors Ananya Behera and Christian Sesta
	 @version 9.1
	 @datemodified 7th November 2014
*/

package cmsystem

class UserAccount {
	
	String firstName
	String lastName
	String username
	String password
	
	/**
		Database mappings and relationships are taken care of by the syntax below:
		a) Every user account has a particular defined permission attached to it
		b) Every user may have many document uploads attached to it
	*/
	static belongsTo = [permission:Permission]
	static hasMany = [documents:Document]
	
	/**
		Identifies that the userAccount class is indexed for search purposes
	*/
	static searchable = true
	
    static constraints = {
		firstName size: 1..50
		lastName size: 1..50
		username size: 1..20
		password size: 1..128
    }

    /**
		Ensures that the domain class is mapped to the correct database table.
    */
    static mapping = {
    	table 'UserAccount'
    }
}
