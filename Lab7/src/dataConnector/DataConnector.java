package dataConnector;

import java.io.*;
import payments.*;

public class DataConnector {
	private String dir;
	private String file;
	
	public DataConnector(String dir, String file) {
		this.dir = dir;
		this.file = file;
	}
	
	public String getFiles() {
		return dir + File.separator + file + "_*";
	}
	
	public void override(Admin[] admins, Client[] clients) throws IOException {
		FileOutputStream fileOfA = new FileOutputStream(dir + File.pathSeparator + file + "_admins");
		try (ObjectOutputStream oos = new ObjectOutputStream(fileOfA)) {
			oos.writeInt(admins.length);
			for (int i = 0; i < admins.length; i++) {
				oos.writeObject(admins[i]);
			}
			oos.flush();
		}
		FileOutputStream fileOfC = new FileOutputStream(dir + File.pathSeparator + file + "_clients");
		try (ObjectOutputStream oos = new ObjectOutputStream(fileOfC)) {
			oos.writeInt(clients.length);
			for (int i = 0; i < clients.length; i++) {
				oos.writeObject(clients[i]);
			}
			oos.flush();
		}
	}
	
	public Admin[] getAdmins() throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(dir + File.pathSeparator + file + "_admins");
		try (ObjectInputStream oin = new ObjectInputStream(fis)) {
			int length = oin.readInt();
			Admin[] result = new Admin[length];
			for (int i = 0; i < length; i++) {
				result[i] = (Admin) oin.readObject();
			}
			return result;
		}
	}
	
	public Client[] getClients() throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(dir + File.pathSeparator + file + "_clients");
		try (ObjectInputStream oin = new ObjectInputStream(fis)) {
			int length = oin.readInt();
			Client[] result = new Client[length];
			for (int i = 0; i < length; i++) {
				result[i] = (Client) oin.readObject();
			}
			return result;
		}
	}
	

}
