/**
 Domain model class which defines the structure of Tag data.

 @authors Ananya Behera and Christian Sesta
 @version 7.1
 @datemodified 10th November 2014
*/

package cmsystem

class Tag {

	String tagName
	String tagDesc
	Date dateCreated = new Date()
	Date dateUpdated = new Date()
	
	/**
		Describes the database relationships among the models.
		a) Each tag belongs to one category
		b) Each tag belongs many or none of the rows in the DocTag table
	*/
	static belongsTo = [category:Category]
	static hasMany = [docTags:DocTag]
	
	static searchable = true

    static constraints = {
		tagName size: 1..100
		tagDesc size: 1..1000
    }
	
	/**
		Maps the Tag domain class to the corresponding table in the database.
	*/
	static mapping = {
		table 'Tag'
	}
}
