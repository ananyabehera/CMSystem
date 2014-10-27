package cmsystem

class Category {
	
	String CatgName
	String catgDesc
	Date dateCreated
	Date dateUpdated
	
	static hasMany = [tag_categories:Tag_Category, doc_tag_categories:Doc_Tag_Category]
	
    static constraints = {
		catgName size: 1..100
		catgDesc size: 1..1000
    }
	
	static mapping = {
		table 'Category'
	}
}
