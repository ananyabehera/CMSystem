class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?" {}

		"/"(view:"nav/index")
		"500"(view:'error/error')
	}
}
