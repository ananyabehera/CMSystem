class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?" {}

		"/"(view:"UserAccount/index")
		"500"(view:'error/500Error')
	}
}
