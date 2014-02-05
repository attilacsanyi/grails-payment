import paymenttracking.Account

class BootStrap {

    def init = { servletContext ->
		def joe = new Account(name: "Joe", email: "joe@grails.com").save(failOnError: true)
		def patty = new Account(name: "Patty", email: "patty@grails.com").save(failOnError: true)
    }
	
    def destroy = {
    }
}
