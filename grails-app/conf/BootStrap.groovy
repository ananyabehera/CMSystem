import cmsystem.*

class BootStrap {

    def init = { servletContext ->
		
		def admin = new Permission(pType: 'Admin').save(flush: true)
		def user = new Permission(pType: 'User').save(flush: true)
		
		new UserAccount(firstName: 'Default', lastName: 'Default', username: 'admin', 
			password: 'c7ad44cbad762a5da0a452f9e854fdc1e0e7a52a38015f23f3eab1d80b931dd472634dfac71cd34ebc35d16ab7fb8a90c81f975113d6c7538dc69dd8de9077ec', 
			permission: admin).save(flush: true)
		new UserAccount(firstName: 'Default', lastName: 'Default', username: 'user',
			password: 'c7ad44cbad762a5da0a452f9e854fdc1e0e7a52a38015f23f3eab1d80b931dd472634dfac71cd34ebc35d16ab7fb8a90c81f975113d6c7538dc69dd8de9077ec',
			permission: user).save(flush: true)

		def newCatg = new Category(catgName: 'Skills', catgDesc: 'Expertise').save(flush: true)

		def newCatg1 = new Category(catgName: 'Document Type', catgDesc: 'Different document types uploaded to the system').save(flush: true)
		def newCatg2 = new Category(catgName: 'Skills', catgDesc: 'Expertise shown').save(flush: true)
		def newCatg3 = new Category(catgName: 'Business Unit', catgDesc: ' The particular Line of Service').save(flush: true)
		def newCatg4 = new Category(catgName: 'Grade', catgDesc: 'The grade level of the PwC staff member').save(flush: true)
		
    }
    def destroy = {
    }
}
