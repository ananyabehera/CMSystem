/**
 Domain model class which defines the structure of Category data.

 @authors Ananya Behera and Christian Sesta
 @version 5.1
 @datemodified 10th November 2014
*/

package cmsystem

class Category {
	
	String catgName
	String catgDesc
	Date dateCreated = new Date()
	Date dateUpdated = new Date()

	static searchable = true
	
	/**
		Defines that the Tag and DocCategory domain models have a one-to-many relationship with the Category domain model.
		i.e. One Category can have Many Tags.
		i.e. One Category can have Many Documents.
	 */
	static hasMany = [tags:Tag, docCategories:DocCategory]
	
	/**
		Defines the constraints of specified fields in the Category domain class.
	 */
    static constraints = {
		catgName size: 1..100
		catgDesc size: 1..1000
    }
	
	/**
		Defines the mapping of the Category domain class.
	 */
	static mapping = {
		table 'Category'
	}
}
