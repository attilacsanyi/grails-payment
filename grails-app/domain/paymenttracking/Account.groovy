package paymenttracking

class Account {
	
	String name
	String email
	Integer balance = 200
	
	static constraints = {
		name blank: false, unique: true
		email email: true, blank: false, unique: true
	}
	
	String toString() { return name }
}
