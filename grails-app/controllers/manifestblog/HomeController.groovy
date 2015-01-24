package manifestblog

class HomeController {

	def springSecurityService
	
    def index() { 
		def user = springSecurityService.currentUser;
	 [posts: Post.all()]
	}
}
