package people;

import contact_information.Address;
import contact_information.PhoneNumber;

import java.util.ArrayList;

public class Employee extends Person {
	
	protected String office;
	protected double salary;

	public Employee(String firstName, String lastName, String emailAddress, Address address, PhoneNumber[] phoneNumbers,
			String office, double salary) {
		super(firstName, lastName, emailAddress, address, phoneNumbers);
		this.office = office;
		this.salary = salary;
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public boolean equals(Employee employee) {
			boolean isSamePhoneNumbers = true;
			for(PhoneNumber phoneNumber: employee.phoneNumbers) {
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
					this.firstName.equalsIgnoreCase(employee.firstName) &&
					this.lastName.equalsIgnoreCase(employee.lastName) &&
					this.emailAddress.equalsIgnoreCase(employee.emailAddress) &&
					this.office.equalsIgnoreCase(employee.office) &&
					this.salary == employee.salary;
	}

	@Override
	public String toString() {
		String output = "Name: " + firstName + " " + lastName + "\nEmail: " + emailAddress + "\nAddress: " + address
				+ "\nOffice: " + office + "\nSalary: " + salary + "\nPhone Number(s): \n";
		
		for(PhoneNumber phoneNumber: phoneNumbers)
			output += phoneNumber.toString() + " \n";
		
		return output;
	}
}