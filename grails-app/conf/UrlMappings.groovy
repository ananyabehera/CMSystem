class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?" {}

		"/"(view:"Nav/index")
		"500"(view:'error/error')
	}
}
