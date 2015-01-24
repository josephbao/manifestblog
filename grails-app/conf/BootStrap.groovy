import manifestblog.Role
import manifestblog.User
import manifestblog.UserRole

class BootStrap {
	def springSecurityService;
    def init = { servletContext -> 
		def userRole = Role.findByAuthority('ROLE_USER') ?: new Role(authority: 'ROLE_USER').save(failOnError: true)
        def adminRole = Role.findByAuthority('ROLE_ADMIN') ?: new Role(authority: 'ROLE_ADMIN').save(failOnError: true)

        def adminUser = User.findByUsername('admin') ?:
           new User(username: 'admin', password: springSecurityService.encodePassword('admin'), enabled: true).save(failOnError: true)

        def bob = User.findByUsername('bob') ?:
                new User(username: 'bob', password: springSecurityService.encodePassword('bob'), enabled: true).save(failOnError: true)

        if (!adminUser.authorities.contains(adminRole)) {
            UserRole.create adminUser, adminRole
            UserRole.create bob, userRole
        }
    }
    def destroy = {
    }
}
