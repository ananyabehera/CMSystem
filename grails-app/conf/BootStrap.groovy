import cmsystem.*
import grails.converters.*

class BootStrap {

    def init = { servletContext ->
		
		def admin = new Permission(pType: 'Admin').save(flush: true)
		def user = new Permission(pType: 'User').save(flush: true)
		
		new UserAccount(firstName: 'donny', lastName: 'kurniawan', username: 'admin', 
			password: 'c7ad44cbad762a5da0a452f9e854fdc1e0e7a52a38015f23f3eab1d80b931dd472634dfac71cd34ebc35d16ab7fb8a90c81f975113d6c7538dc69dd8de9077ec', 
			permission: admin).save(flush: true)
		new UserAccount(firstName: 'jake', lastName: 'rush', username: 'user',
			password: 'b14361404c078ffd549c03db443c3fede2f3e534d73f78f77301ed97d4a436a9fd9db05ee8b325c0ad36438b43fec8510c204fc1c1edb21d0941c00e9e2c1ce2',
			permission: user).save(flush: true)
		new UserAccount(firstName: 'christian', lastName: 'sesta', username: 'csesta',
			password: 'f6b9e4ad69f842a0322a638164c195f572415c38363358920132f4f47bec3a5dfefef781358e43bea1f35556de40d386ab44d09128b8e3f3b158db3784c75521',
			permission: admin).save(flush: true)
		new UserAccount(firstName: 'ananya', lastName: 'behera', username: 'abehera',
			password: '3c2c8cc53a590b4570798b424f28ea8aef6b2b9d85fed5fb0ea56310dafe0c142a4201dd6be6ce074efd93b682a19a233de0936a128141f8cea0912e444f88c5',
			permission: admin).save(flush: true)

		def newCatg1 = new Category(catgName: 'Document Type', catgDesc: 'Different document types uploaded to the system').save(flush: true)
		def newCatg2 = new Category(catgName: 'Skills', catgDesc: 'Expertise shown').save(flush: true)
		def newCatg3 = new Category(catgName: 'Business Unit', catgDesc: ' The particular Line of Service').save(flush: true)
		def newCatg4 = new Category(catgName: 'Grade', catgDesc: 'The grade level of the PwC staff member').save(flush: true)

		def newTag1 = new Tag(tagName: 'Digital', tagDesc: 'Digital Change Services', category: newCatg3).save(flush: true)
		def newTag2 = new Tag(tagName: 'Java', tagDesc: 'Oracle\'s Java Language', category: newCatg2).save(flush: true)
		
		/*new Biography(firstName: 'Christian', lastName: 'Sesta', title: 'Senior Technology Manager', team: 'Digital Change Services',
			bioDesc: 'I am a 23 year old Data Analyst.', oneLiner: '“If you don’t try, you will never succeed.”', 
			loveSentance: 'Our office has an awesome Coffee Machine in its DigitalDigs Building').save(flush: true)	 
		new Biography(firstName: 'Cloris', lastName: 'Ye', title: 'Senior Digital Manager', team: 'Digital Change Services',
			bioDesc: 'I am a 28 year old Data Warehousing Manager. ', oneLiner: '“Failure can lead to success.”',
			loveSentance: 'Super Digitals building is awesome, stylish, and cool.').save(flush: true)*/
    }
    def destroy = {
    }
}
