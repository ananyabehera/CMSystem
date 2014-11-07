class UrlMappings {

	static mappings = {
		
		"/$controller/$action?/$id?"(parseRequest: true ){
			
			//action = [DELETE:"delete", GET:"show", POST:"save", PUT:"update"]
			//action = [delete: "DELETE", show: "GET", save: "POST", update: "PUT"]
			
		}

		/*"/tag/$id?"(controller: "tag", parseRequet: true) {
			action = [DELETE:"delete", GET:"show", POST:"save", PUT:"update"]
		}*/

		"/"(view:"UserAccount/index")
		"500"(view:'error/500Error')
	}
}
