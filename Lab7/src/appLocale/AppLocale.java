package appLocale;

import java.util.Locale;
import java.util.ResourceBundle;

public class AppLocale {
	private static Locale loc = new Locale("ru", "RU");
	private static ResourceBundle res = ResourceBundle.getBundle("Msg", loc);
	
	public static String getString(String key) {
		return res.getString(key);
	}
	
	public static Locale get() {
		return loc;
	}
}
