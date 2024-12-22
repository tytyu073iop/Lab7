package payments;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;

import appLocale.AppLocale;

public class Admin implements Serializable {
	private static final long serialVersionUID = -3854186481562537365L;
	
	public final Date creationDate = new Date();

	public String getCreationDate() {
		DateFormat dateFormatter = DateFormat.getDateTimeInstance(
				DateFormat.DEFAULT, DateFormat.DEFAULT, AppLocale.get());
		String dateOut = dateFormatter.format(creationDate);
		return dateOut;
	}

	void block(CreditCard card) {
		System.out.println(AppLocale.getString("admin_blocked_message") + card);
		card.blocked = true;
	}
	
	@Override
	public String toString() {
		return AppLocale.getString("admin_to_string") + " " + getCreationDate();
	}
}
