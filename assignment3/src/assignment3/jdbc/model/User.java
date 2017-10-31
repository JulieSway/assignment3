package assignment3.jdbc.model;

import java.sql.Date;
import java.util.ArrayList;

public class User extends Person{
	private Boolean userAgreement;

	public User(int id, String firstName, String lastName, String username, String password, String email, Date dob) {
		super(id, firstName, lastName, username, password, email, dob);
	}

	public User(int id, String firstName, String lastName, String username, String password, String email, Date dob,
			Boolean userAgreement) {
		super(id, firstName, lastName, username, password, email, dob);
		this.userAgreement = userAgreement;
	}

	public Boolean getUserAgreement() {
		return userAgreement;
	}

	public void setUserAgreement(Boolean userAgreement) {
		this.userAgreement = userAgreement;
	}
}
