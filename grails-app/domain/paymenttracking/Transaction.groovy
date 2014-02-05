package paymenttracking

class Transaction {

    String origin
	String target
	Integer amount
	
    static constraints = {
		origin blank: false
		target blank: false, validator: { val, obj -> val != obj.origin }
		amount blank: false, min: 1
    }
	
	String toString() { return origin + " -> " + target + " : " + amount }
}
