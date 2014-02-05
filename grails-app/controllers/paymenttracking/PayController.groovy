package paymenttracking

class PayController {
		
	// Services
	def accountService
	def notifierService
	def transactionService
	
    def index = {
		[accounts: accountService.getAccounts()]
	}
	
	def doTrans = {
		
		// Default values
		String hasError = ""
		String message = ""
		
		// Create transaction
		def trans = new Transaction(origin: params.'origin', target: params.'target', amount: params.int('amount'))
		if (trans.validate()) {
			if (trans.amount > 0) {
				Account origin = accountService.getAccountByName(trans.origin)
				
				if(origin.balance >= trans.amount)
				{
					// Update origin
					origin.balance -= trans.amount
					accountService.saveAccount(origin)
					
					// Update target
					Account target = accountService.getAccountByName(trans.target)
					
					target.balance += trans.amount
					accountService.saveAccount(target)
					
					// Save transaction
					transactionService.saveTransaction(trans)
					message = "Transaction saved: " + trans
					
					// Sending emails (uncomment after set the proper smtp configuration in Config.groovy)
					//notifierService.sendNotifyMail(origin, target, trans.amount)
				}
				else
				{
					hasError = origin.name + " can pay only upto " + origin.balance
				}
			}
		}
		else {
			trans.errors.allErrors.each {
				hasError += it
			}
		}
		
		render view: 'index', model: [
								accounts: accountService.getAccounts(),
								error: hasError,
								info: message]
		return
	}
	


}
