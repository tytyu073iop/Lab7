package payments;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;

import appLocale.AppLocale;

public class Client implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public final Date creationDate = new Date();

	public String getCreationDate() {
		DateFormat dateFormatter = DateFormat.getDateTimeInstance(
				DateFormat.DEFAULT, DateFormat.DEFAULT, AppLocale.get());
		String dateOut = dateFormatter.format(creationDate);
		return dateOut;
	}

	CreditCard card;
	Account account;
	
	public Client(CreditCard card, Account account) {
		this.card = card;
		this.account = account;
	}

	public boolean pay() {
		return !card.blocked;
	}
	
	public boolean sendToAccount(Account account, long amount) {
		if (card.decrease(amount)) {
			System.out.println(AppLocale.getString("client_to_string") + account);
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return AppLocale.getString("client_sent_to") + card + " " + account + " " + getCreationDate();
	}
}
