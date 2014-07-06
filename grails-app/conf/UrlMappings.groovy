class UrlMappings {

	static mappings = {
        "/propietarios"(resources:"propietario")
        "/"(view:"/index")
        "500"(view:'/error')
	}
}
