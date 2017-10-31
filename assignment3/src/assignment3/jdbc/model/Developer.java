package assignment3.jdbc.model;

import java.sql.Date;
import java.util.ArrayList;

public class Developer extends Person{
	public Developer(int id, String firstName, String lastName, String username, String password, String email, Date dob) {
		super(id, firstName, lastName, username, password, email, dob);
	}
	public Developer(int id, String firstName, String lastName, String username, String password, String email, Date dob,
			String developerKey) {
		super(id, firstName, lastName, username, password, email, dob);
		this.developerKey = developerKey;
		
	}

	
	public String getDeveloperKey() {
		return developerKey;
	}
	public void setDeveloperKey(String developerKey) {
		this.developerKey = developerKey;
	}
	public ArrayList<Website> getWebsites() {
		return websites;
	}
	public void setWebsites(ArrayList<Website> websites) {
		this.websites = websites;
	}
	private String developerKey;
	private ArrayList<Website> websites;

	public String toString() {
		return super.toString() + "-" + developerKey ;
	}
	
}
