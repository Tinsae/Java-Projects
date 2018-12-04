package people;

import contact_information.Address;
import contact_information.PhoneNumber;

public class Faculty extends Employee {
	private String officeHours;
	private String rank;

	public Faculty(String firstName, String lastName, String emailAddress, Address address, PhoneNumber[] phoneNumbers,
			String office, double salary, String officeHours, String rank) {
		super(firstName, lastName, emailAddress, (Address) address, phoneNumbers, office, salary);
		this.officeHours = officeHours;
		this.rank = rank;
	}

	public String getOfficeHours() {
		return officeHours;
	}

	public void setOfficeHours(String officeHours) {
		this.officeHours = officeHours;
	}
	
	public String getRank() {
		return rank;
	}
	
	public void setRank(String rank) {
		this.rank = rank;
	}
	
	public boolean equals(Faculty faculty) {
		boolean isSamePhoneNumbers = true;
		for(PhoneNumber phoneNumber: faculty.phoneNumbers) {
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
				this.firstName.equalsIgnoreCase(faculty.firstName) &&
				this.lastName.equalsIgnoreCase(faculty.lastName) &&
				this.emailAddress.equalsIgnoreCase(faculty.emailAddress) &&
				this.salary == faculty.salary &&
				this.office.equalsIgnoreCase(faculty.office) &&
				this.address.equals(faculty.address) &&
				this.rank.equalsIgnoreCase(faculty.rank);
	}
	
	@Override
	public String toString() {
		String output = "Name: " + firstName + " " + lastName + "\nEmail: "  + emailAddress
				+ "\nAddress: " + address + "\nOffice: " + office + "\nSalary: "
				+ salary + "\nOffice Hours: " + officeHours + "\nRank: " + rank +
				"\nPhone Number(s): \n";
				
		for(PhoneNumber phoneNumber: phoneNumbers)
			output += phoneNumber.toString() + " \n";
		return output;
	}
}