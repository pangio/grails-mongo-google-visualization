import com.pangio.company.*
import com.pangio.company.auth.Role
import com.pangio.company.auth.User
import com.pangio.company.auth.UserRole

class BootStrap {


    def springSecurityService

    def init = { servletContext ->

        createEmployees()
        createAdminUsers()

    }

    def destroy = {
    }

    private void createEmployees() {
        new Employee(firstName: 'Vladimir', lastName: 'Something', salary: 21234L, gender: Gender.FEMALE, country: Country.RUSSIA).save(flush: true)
        new Employee(firstName: 'Wong', lastName: 'Something', salary: 41234L, gender: Gender.FEMALE, country: Country.CHINA).save(flush: true)
        new Employee(firstName: 'John', lastName: 'Something', salary: 51234L, gender: Gender.MALE, country: Country.UNITED_STATES).save(flush: true)
        new Employee(firstName: 'Gilbert', lastName: 'Something', salary: 21234L, gender: Gender.MALE, country: Country.BRAZIL).save(flush: true)
        new Employee(firstName: 'Pierre', lastName: 'Something', salary: 21234L, gender: Gender.MALE, country: Country.CANADA).save(flush: true)
        new Employee(firstName: 'Matt', lastName: 'Something', salary: 21234L, gender: Gender.MALE, country: Country.AUSTRALIA).save(flush: true)

    }
    private void createAdminUsers() {

        def userRole = new Role(authority: 'ROLE_USER').save(flush: true)

        def adminUser = new User(username: 'admin', password: 'pass')
        adminUser.save(flush: true)

        UserRole.create adminUser, userRole, true

        assert User.count() == 1
        assert Role.count() == 1
        assert UserRole.count() == 1

    }
}
