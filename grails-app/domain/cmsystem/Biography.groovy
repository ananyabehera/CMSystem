package cmsystem

class Biography {
	
	byte[] iconFile
	String iconFileType
	String firstName
	String lastName
	String title
	String team
	String bioDesc
	String oneLiner
	String loveSentance
	
    static constraints = {
		iconFile nullable:false,
			 maxSize:1073741824		
		iconFileType size: 1..5
		firstName size: 1..50
		lastName size: 1..50
		title size: 1..100
		team size: 1..100
		bioDesc size: 1..1000
		oneLiner size: 1..1000
		loveSentance size: 1..1000
    }
	
	static mapping = {
		table 'Biography'
	}
}
