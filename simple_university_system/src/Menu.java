import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

import contact_information.*;
import people.*;
import university_database.*;

public class Menu {
	public Menu(Database db) {
		Scanner scanner = new Scanner(System.in);
		int choose;
		do {
			System.out.println("\nChoose an option: \n");
			System.out.println("***************************************");
			System.out.print("1. Add a Person \n");
			System.out.print("2. Remove Person\n");
			System.out.print("3. Find Person.\n");
			System.out.print("4. Choose CSV file to load to Program.\n");
			System.out.print("5. Print Database to a TXT File/\n");
			System.out.print("6. Exit.\n");
			System.out.println("***************************************");
			choose = scanner.nextInt();

			switch (choose) {
			case 1:
				System.out.println("What kind of person would you like to add?");
				System.out.println("Student = 1, Faculty = 2, Staff = 3: ");
				int type = scanner.nextInt();
				if (type == 1) {
					System.out.println("Enter the first name: ");
					String fName = scanner.next();
					System.out.println("Enter the last name: ");
					String lName = scanner.next();
					System.out.println("Enter the email address: ");
					String eAddress = scanner.next();
					System.out.println("Enter an Address: ");
					System.out.println("Enter the Street Number: ");
					int sNumber = scanner.nextInt();
					System.out.println("Enter the Apartment Number: ");
					int aptNumber = scanner.nextInt();
					System.out.println("Enter the Street Name: ");
					String sName = scanner.next();
					System.out.println("Enter the City: ");
					String c = scanner.next();
					System.out.println("Enter the State: ");
					String s = scanner.next();
					System.out.println("Enter the Zip Code: ");
					int zip = scanner.nextInt();
					System.out.println("What is the students class standing? ");
					String newClassStanding = scanner.next();
					System.out.println("Enter the type of phone that you have: ");
					String phoneType = scanner.next();
					System.out.println("Enter the area code of your phone number: ");
					int area = scanner.nextInt();
					System.out.println("Enter the first 3 numbers of your phone number: ");
					int prefix = scanner.nextInt();
					System.out.println("Enter the last 4 digits of your phone number: ");
					int suffix = scanner.nextInt();

					Address newAddress = new Address(sNumber, aptNumber, sName, c, s, zip);
					PhoneNumber[] newPhoneNumber = { new PhoneNumber(phoneType, area, prefix, suffix) };
					Person newPerson = new Student(fName, lName, eAddress, newAddress, newPhoneNumber,
							newClassStanding);
					db.addPerson(newPerson);
					System.out.println("\nThe student has been added to the Database.\n");
					db.printDatabase();
					break;
				}
				if (type == 2) {
					System.out.println("Enter the first name: ");
					String fName;
					fName = scanner.next();
					System.out.println("Enter the last name: ");
					String lName;
					lName = scanner.next();
					System.out.println("Enter the email address: ");
					String eAddress;
					eAddress = scanner.next();
					System.out.println("Enter an Address: ");
					System.out.println("Enter the Street Number: ");
					int sNumber;
					sNumber = scanner.nextInt();
					System.out.println("Enter the Apartment Number: ");
					int aptNumber;
					aptNumber = scanner.nextInt();
					System.out.println("Enter the Street Name: ");
					String sName;
					sName = scanner.next();
					System.out.println("Enter the City: ");
					String c;
					c = scanner.next();
					System.out.println("Enter the State: ");
					String s;
					s = scanner.next();
					System.out.println("Enter the Zip Code: ");
					int zip;
					zip = scanner.nextInt();
					System.out.println("Enter the type of phone that the Faculty has: ");
					String phoneType;
					phoneType = scanner.next();
					System.out.println("Enter the area code of the phone number: ");
					int area;
					area = scanner.nextInt();
					System.out.println("Enter the first 3 numbers of the phone number: ");
					int prefix;
					prefix = scanner.nextInt();
					System.out.println("Enter the last 4 digits of the phone number: ");
					int suffix;
					suffix = scanner.nextInt();
					System.out.println("Where is his/her office located? ");
					String newOffice = scanner.next();
					System.out.println("What is his/her salary? ");
					double newSalary = scanner.nextDouble();
					System.out.println("What is his/her office hours? ");
					String newOfficeHours = scanner.next();
					System.out.println("What is his/her rank? ");
					String newRank = scanner.next();

					Address newAddress = new Address(sNumber, aptNumber, sName, c, s, zip);
					PhoneNumber[] newPhoneNumber = { new PhoneNumber(phoneType, area, prefix, suffix) };
					Person newPerson = new Faculty(fName, lName, eAddress, newAddress, newPhoneNumber, newOffice,
							newSalary, newOfficeHours, newRank);
					db.addPerson(newPerson);
					System.out.println("\nThe Faculty has been added to the Database.\n");
					db.printDatabase();
					break;
				}
				if (type == 3) {
					System.out.println("Enter the first name: ");
					String fName;
					fName = scanner.next();
					System.out.println("Enter the last name: ");
					String lName;
					lName = scanner.next();
					System.out.println("Enter the email address: ");
					String eAddress;
					eAddress = scanner.next();
					System.out.println("Enter an Address: ");
					System.out.println("Enter the Street Number: ");
					int sNumber;
					sNumber = scanner.nextInt();
					System.out.println("Enter the Apartment Number: ");
					int aptNumber;
					aptNumber = scanner.nextInt();
					System.out.println("Enter the Street Name: ");
					String sName;
					sName = scanner.next();
					System.out.println("Enter the City: ");
					String c;
					c = scanner.next();
					System.out.println("Enter the State: ");
					String s;
					s = scanner.next();
					System.out.println("Enter the Zip Code: ");
					int zip;
					zip = scanner.nextInt();
					System.out.println("Enter the type of phone that the staff has: ");
					String phoneType = scanner.next();
					System.out.println("Enter the area code of the number: ");
					int areaCode = scanner.nextInt();
					System.out.println("Enter the first 3 numbers: ");
					int prefix = scanner.nextInt();
					System.out.println("Enter the last 4 numbers: ");
					int suffix = scanner.nextInt();
					System.out.println("Where is his/her office located? ");
					String newOffice = scanner.next();
					System.out.println("What is his/her salary? ");
					double newSalary = scanner.nextDouble();
					System.out.println("What is his/her office hours? ");
					String newOfficeHours = scanner.next();
					System.out.println("What is his/her title? ");
					String newTitle = scanner.next();

					Address newAddress = new Address(sNumber, aptNumber, sName, c, s, zip);
					PhoneNumber[] newPhoneNumber = { new PhoneNumber(phoneType, areaCode, prefix, suffix) };
					Person newPerson = new Faculty(fName, lName, eAddress, newAddress, newPhoneNumber, newOffice,
							newSalary, newOfficeHours, newTitle);
					db.addPerson(newPerson);
					System.out.println("\nThe Staff has been added to the Database.\n");
					db.printDatabase();
					break;
				}
			case 2:
				
				System.out.println("Enter the first name of the person: ");
				String firstName;
				firstName = scanner.next();
				System.out.println("Enter the last name of the person: ");
				String lastName;
				lastName = scanner.next();
				String fullName = firstName + " " + lastName;
				db.removePerson(fullName);
				db.printDatabase();
				break;
			case 3:
				System.out.println("Enter the first name of the person: ");
				String fiName;
				fiName = scanner.next();
				System.out.println("Enter the last name of the person: ");
				String laName;
				laName = scanner.next();
				String fuName = fiName + " " + laName;
				db.findPerson(fuName);
				break;
			case 4:
				JFileChooser jfc = new JFileChooser(".");
				int jfcUserOption = jfc.showOpenDialog(null);
				if (jfcUserOption == JFileChooser.APPROVE_OPTION) {
					File chosenFile = jfc.getSelectedFile();
					System.out.println("The file you chose was: " + chosenFile.getName() + "\n");
					DatabaseFileIO.readCSV(chosenFile);
				}
				else if (jfcUserOption == JFileChooser.CANCEL_OPTION) {
					System.out.println("You chose cancel");
				}
				else if (jfcUserOption == JFileChooser.ERROR_OPTION) {
					System.out.println("There was some error!");
				}
				break;
			case 5:
				DatabaseFileIO.fileWrite();
				break;
			case 6:
				System.out.println("Goodbye.");
				System.exit(0);
			}
		} while (choose != 6);
	}
}
