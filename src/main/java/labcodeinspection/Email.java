package labcodeinspection;

import java.util.Locale;

public class Email {

	private final String m_firstName;
	private final String m_lastName;
	private String password;
	private String department;
	private final int DEFAULTPASSWORDLENGTH = 8;
	private String email;

	/**
	 * Builds a new instance of the Email Class.
	 *
	 * @param firstName The first name of the email´s owner.
	 * @param lastName The last name of the email´s owner.
	 */
	public Email(String firstName, String lastName) {
		this.m_firstName = firstName;
		this.m_lastName = lastName;
	}

	/**
	 * Prints on screen the: email´s owner name, department, email and password
	 */
	public void showInfo() {
		System.out.println("\nFIRST NAME= " + m_firstName + "\nLAST NAME= " + m_lastName);
		System.out.println("DEPARMENT= " + department + "\nEMAIL= " + email + "\nPASSWORD= " + password);
	}

	/**
	 * Sets the department field of the Email instance based on the depChoice.
	 *
	 * @param depChoice An integer value that represents a department.
	 */
	public void setDeparment(int depChoice) {
		switch (depChoice) {
		case 1:
			this.department = "sales";
			break;
		case 2:
			this.department = "dev";
			break;
		case 3:
			this.department = "acct";
			break;
		default:
			throw new IllegalArgumentException("Invalid department choice: " + depChoice);
		}
	}

	private String randomPassword(int length) {
		String set = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890#$&@*";
		char[] password = new char[length];
		for (int i = 0; i < length; i++) {
			int rand = (int) (Math.random() * set.length());
			password[i] = set.charAt(rand);
		}
		return new String(password);
	}

	/**
	 * Generates an email address using the first name, last name and department
	 * of the owner, also generates a random password.
	 */
	public void generateEmail() {
		this.password = this.randomPassword(this.DEFAULTPASSWORDLENGTH);
		this.email = this.m_firstName.toLowerCase(Locale.ROOT) + this.m_lastName.toLowerCase(Locale.ROOT) + "@" + this.department
				+ ".espol.edu.ec";
	}
}
