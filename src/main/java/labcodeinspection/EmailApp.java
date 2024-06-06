package labcodeinspection;

import java.util.Scanner;


public class EmailApp {

	private EmailApp() {}
	
	/**
	 * Asks for the: first name, last name and department option chosen of the user.
	 * With this data, the method generates an email and shows it 
	 * @param args Console arguments
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter your first name: ");
		String firstName = sc.nextLine();

		System.out.print("Enter your last name: ");
		String lastName = sc.nextLine();

		System.out.print("\nDEPARTMENT CODE\n1. for sales\n2. for Development\n3. for accounting\nEnter code: ");

		int depChoice = sc.nextInt();
		sc.close();

		Email email = new Email(firstName, lastName);
		try {
			email.setDeparment(depChoice);
		}catch (IllegalArgumentException e){
			System.err.println("An error occurred: " + e.getMessage());
            System.exit(1);
		}
		email.generateEmail();
		email.showInfo();
	}
}
