/**
 Domain model class which defines the structure of Permission data.
 Essentially this domain class is an enumeration of the Permission level and privileges associated with 
 each user. 

 @authors Ananya Behera and Christian Sesta
 @version 1.1
 @datemodified 1st November 2014
*/

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
