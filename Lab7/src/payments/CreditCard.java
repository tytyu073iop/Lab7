package payments;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;

import appLocale.AppLocale;

public class CreditCard implements Serializable {

	private static final long serialVersionUID = 2L;
	
	public final Date creationDate = new Date();

	public String getCreationDate() {
		DateFormat dateFormatter = DateFormat.getDateTimeInstance(
				DateFormat.DEFAULT, DateFormat.DEFAULT, AppLocale.get());
		String dateOut = dateFormatter.format(creationDate);
		return dateOut;
	}
	
	long balance = 0;
	
	long limit = 0;
	
	boolean blocked = false;
	
	public boolean isBlocked() {
		return blocked;
	}
	
	boolean decrease(long amount) {
		if (blocked) {
			return false;
		}
		balance -= amount;
		return true;
	}
	
	public CreditCard(long balance, long limit) {
		this.balance = balance;
		this.limit = limit;
	}
	
	@Override
	public String toString() {
		return AppLocale.getString("credit_card_to_string").formatted(limit, balance) + " " + getCreationDate();
	}

}
