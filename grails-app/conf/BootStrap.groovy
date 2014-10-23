import cmsystem.User
import cmsystem.Tag

class BootStrap {

    def init = { servletContext ->
    
		// Check whether the User test data already exists.
		if (!User.count()) {
			new User(firstName: "Christian", lastName: "Sesta", username: "sesta", password: "sesta", 
					level: "ADMIN").save(failOnError: true)
			new User(firstName: "Ananya", lastName: "Behara", username: "ananya", password: "ananya", 
					level: "ADMIN").save(failOnError: true)
			new User(firstName: "Jake", lastName: "Rush", username: "rush", password: "rush",
					level: "USER").save(failOnError: true)
			new User(firstName: "John", lastName: "Smith", username: "smith", password: "smith",
					level: "USER").save(failOnError: true)
		}
		
		// Check whether the Tag test data already exists.
		if(!Tag.count()) {
			new Tag(tagName: "PwC's Digital Change Services", 
				tagDesc: "This is test data for PwC's Digital Change Services.", dateCreated: date(), 
				dateUpdated: new Date()).save(failOnError: true)
			new Tag(tagName: "Private Clients",
				tagDesc: "This is test data for Private Clients.", dateCreated: date(),
				dateUpdated: new Date()).save(failOnError: true)
			new Tag(tagName: "Technology Consulting",
				tagDesc: "This is test data for PwC's Technology Consulting.", dateCreated: date(),
				dateUpdated: new Date()).save(failOnError: true)
			new Tag(tagName: "Risk & Security",
				tagDesc: "This is test data for Risk & Security.", dateCreated: date(),
				dateUpdated: new Date()).save(failOnError: true)
		}
			
	}
    def destroy = {
    }
}
