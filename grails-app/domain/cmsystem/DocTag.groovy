/**
 Domain model class which represents the data in the bridging class between Document and Tag

 @authors Ananya Behera and Christian Sesta
 @version 4.5
 @datemodified 10th November 2014
*/

package cmsystem

/**
	Defines that the Document and Tag domain model have a many-to-many relationship and that 
	this bridging entity breaks down this complex many-to-many relationship into two simpler one to many
	relationships.  Each row in the DocTag table belongs to one Tag and one Document.
*/
class DocTag {

	static belongsTo = [tag: Tag, document: Document]

    static mapping = {
    	table 'DocTag'
    }
}
