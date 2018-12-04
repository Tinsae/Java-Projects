package people;

import contact_information.Address;
import contact_information.PhoneNumber;

public class Staff extends Employee {

	private String title;

	public Staff(String firstName, String lastName, String emailAddress, Address address, PhoneNumber[] phoneNumbers,
			String office, double salary, String title) {
		
		super(firstName, lastName, emailAddress, address, phoneNumbers, office, salary);
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String ti) {
		this.title = ti;
	}
	
	public boolean equals(Staff staff) {
		boolean isSamePhoneNumbers = true;
		for(PhoneNumber phoneNumber: staff.phoneNumbers) {
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
				this.firstName.equalsIgnoreCase(staff.firstName) &&
				this.lastName.equalsIgnoreCase(staff.lastName) &&
				this.emailAddress.equalsIgnoreCase(staff.emailAddress) &&
				this.salary == staff.salary &&
				this.office.equalsIgnoreCase(staff.office) &&
				this.address.equals(staff.address) &&
				this.title.equalsIgnoreCase(staff.title);
	}

	@Override
	public String toString() {
		String output = "Name: " + firstName + " " + lastName + "\nEmail: "  + emailAddress
				+ "\nAddress: " + address + "\nOffice: " + office + "\nSalary: "
				+ salary + "\nTitle: " + title
				+ "\nPhone Number(s): \n";
				
		for(PhoneNumber phoneNumber: phoneNumbers)
			output += phoneNumber.toString() + " \n";
		
		return output;
	}
}