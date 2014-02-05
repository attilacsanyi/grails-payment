package paymenttracking

class TransactionService {

    static transactional = true

    def saveTransaction(Transaction trans)
	{
		trans.save()
	}
	
	Transaction[] findAllByOrigin(String origin)
	{
		Transaction.findAllByOrigin(origin) as Transaction[]
	}
	
	Transaction[] findAllByTarget(String target)
	{
		Transaction.findAllByTarget(target) as Transaction[]
	}
}
