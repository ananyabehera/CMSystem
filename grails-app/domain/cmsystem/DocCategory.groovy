/**
 Domain model class which defines the structure of DocCategory data.

 @authors Ananya Behera and Christian Sesta
 @version 4.5
 @datemodified 10th November 2014
*/

package cmsystem

class DocCategory {
	
	/**
		Defines that the Document and Category domain model have a many-to-many relationship with the Category domain model.
		i.e. Many Categories can have Many Documents
	*/
	static belongsTo = [document:Document, category:Category]
	
	/**
		Defines the mapping of the DocCategory domain class.
	*/
	static mapping = {
		table 'DocCategory'
	}
}
