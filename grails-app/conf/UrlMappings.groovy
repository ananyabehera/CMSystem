class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			
			//action = [GET:"show", POST:"save", PUT:"update", DELETE:"remove"]
			
			constraints {
				// apply constraints here
			}
		}

		"/"(view:"UserAccount/index")
		"500"(view:'error/500Error')
	}
}
