package people;

import contact_information.Address;
import contact_information.PhoneNumber;

public class Student extends Person {
	
	private String classStanding;

	public Student(String firstName, String lastName, String emailAddress, Address address, PhoneNumber[] phoneNumbers,
			String classStanding) {
		
		super(firstName, lastName, emailAddress, address, phoneNumbers);
		this.classStanding = classStanding;
	}

	public String getClassStanding() {
		return classStanding;
	}

	public void setClassStanding(String classStanding) {
		this.classStanding = classStanding;
	}
	
	public boolean equals(Student student) {
		boolean isSamePhoneNumbers = true;
		for(PhoneNumber phoneNumber: student.phoneNumbers) {
			for(PhoneNumber phoneNumberThis: this.phoneNumbers) {
				if(phoneNumber.equals(phoneNumberThis)) {
					continue;
				} else {
					isSamePhoneNumbers = false;
					break;
				}
			}
		}
		return isSamePhoneNumbers &&
				student.firstName.equalsIgnoreCase(this.firstName) &&
				student.lastName.equalsIgnoreCase(this.lastName) &&
				student.emailAddress.equalsIgnoreCase(this.emailAddress) &&
				student.address.equals(this.address) &&
				student.classStanding.equalsIgnoreCase(this.classStanding);
	}

	@Override
	public String toString() {
		String output = "Name: " + firstName + " " + lastName + "\nEmail: " + emailAddress + "\nAddress: " + address
				+ "\nClass Standing: " + classStanding
				+ "\nPhone Number(s): \n";
		
		for(PhoneNumber phoneNumber: phoneNumbers)
			output += phoneNumber.toString() + " \n";
		return output;
	}
}