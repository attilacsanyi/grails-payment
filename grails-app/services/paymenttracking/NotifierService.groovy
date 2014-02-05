package paymenttracking

class NotifierService {

	def mailService
	
    static transactional = true

	def sendNotifyMail(Account origin, Account target, Integer amount)
	{
		// Send payment email
		mailService.sendMail {
			to target.email
			from "cs_ati@yahoo.com"
			subject "Payment received"
			body "Dear ${target.name}\n\nYou received ${amount} from ${origin.name}."
		}
		
		// Send expense email
		mailService.sendMail {
			to origin.email
			from "cs_ati@yahoo.com"
			subject "Payment sent"
			body "Dear ${origin.name}\n\nYou sent ${amount} to ${target.name}."
		}

	}
}
