package test;

import payments.*;

import java.io.IOException;

import dataConnector.*;
import appLocale.*;

public class Test {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Client client = null;
		Admin admin = null;
		
		DataConnector dc = new DataConnector("appdata", "program");
	
		if (false) {
			client = new Client(new CreditCard(100,50), new Account(325857));
			admin = new Admin();
		} else {
			System.out.println(AppLocale.getString("load_from_file"));
			try {
				client = dc.getClients()[0];
			} catch (ClassNotFoundException e) {
				System.out.println("Class not found:" + e);
			} catch (IOException e) {
				System.out.println("IO error:" + e);
			}
			try {
				admin = dc.getAdmins()[0];
			} catch (ClassNotFoundException e) {
				System.out.println("Class not found:" + e);
			} catch (IOException e) {
				System.out.println("IO error:" + e);
			}
		}
		
		System.out.println(client);
		System.out.println(admin);
		
		try {
			dc.override(new Admin[] {admin}, new Client[] {client});
			System.out.println(AppLocale.getString("saved_in") + dc.getFiles());
		} catch (IOException e) {
			System.out.println("IO error:" + e);
		}
	}

}
