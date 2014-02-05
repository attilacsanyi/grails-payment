package paymenttracking

class TransactionController {

    static scaffold = Transaction
	
	// Services
	def accountService
	def transactionService
	
	def show = {
		[accounts: accountService.getAccounts()]
	}
	
	def doSelect = {
		// default values
		String hasError = ""
		def transactions = []
		String balance = "-"

		def origin = Account.findByName(params.'origin')
		
		if (origin != null) {
			balance = origin.balance
			def outgoing = transactionService.findAllByOrigin(origin.name)
			def incoming = transactionService.findAllByTarget(origin.name)
			transactions = [incoming, outgoing]
		}
		else {
			hasError = "Please choose a person"
		}
		
		render view: 'show', model: [accounts: accountService.getAccounts(),
										transactions: transactions,
										error: hasError,
										origin: origin]
		return
	}
}
