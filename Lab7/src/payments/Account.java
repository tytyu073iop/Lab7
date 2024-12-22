package payments;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;

import appLocale.AppLocale;

public class Account implements Serializable {

	private static final long serialVersionUID = 3L;
	
	public final Date creationDate = new Date();

	public String getCreationDate() {
		DateFormat dateFormatter = DateFormat.getDateTimeInstance(
				DateFormat.DEFAULT, DateFormat.DEFAULT, AppLocale.get());
		String dateOut = dateFormatter.format(creationDate);
		return dateOut;
	}
	
	long num;
	
	public Account(long num) {
		this.num = num;
	}
	
	@Override
	public String toString() {
		return AppLocale.getString("account_to_string").formatted(num) + " " + getCreationDate();
	}

}
