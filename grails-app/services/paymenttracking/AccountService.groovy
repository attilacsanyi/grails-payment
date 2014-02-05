package paymenttracking

class AccountService {

    static transactional = true

    Account[] getAccounts() {
    	Account.list() as Account[]
    }
	
	def saveAccount(Account account)
	{
		account.save()
	}
	
	Account getAccountByName(String name)
	{
		Account.findByName(name)
	}
	
}
