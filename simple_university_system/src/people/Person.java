package people;

import java.util.ArrayList;
import java.util.Arrays;

import contact_information.Address;
import contact_information.PhoneNumber;

public class Person {
	
	protected String firstName;
	protected String lastName;
	protected String emailAddress;
	protected Address address;
	protected ArrayList<PhoneNumber> phoneNumbers;

	public Person(String firstName, String lastName, String emailAddress, Address address,
			PhoneNumber... phoneNumberList) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.address = address;
		phoneNumbers = new ArrayList<PhoneNumber>(Arrays.asList(phoneNumberList));
	}

	public String getName() {
		return firstName + " " + lastName;
	}

	public void setName(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getEmail() {
		return emailAddress;
	}

	public void setEmail(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public ArrayList<PhoneNumber> getPhoneNumbers() {
		return phoneNumbers;
	}
	
	public void addPhoneNumber(PhoneNumber phoneNumber) {
		this.phoneNumbers.add(phoneNumber);
	}
	
	public void removePhoneNumber(PhoneNumber phoneNumber) {
		this.phoneNumbers.remove(phoneNumber);
	}
	
	public boolean equals(Person person) {
		boolean isSamePhoneNumbers = true;
		for(PhoneNumber phoneNumber: person.phoneNumbers) {
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
				person.firstName.equalsIgnoreCase(this.firstName) &&
				person.lastName.equalsIgnoreCase(this.lastName) &&
				person.emailAddress.equalsIgnoreCase(this.emailAddress) &&
				person.address.equals(this.address);
	}

	@Override
	public String toString() {
		String output = "Name: " + firstName + " " + lastName + "\nEmail: " + emailAddress + "\nAddress: " + address
				+ "\nPhone Number(s): \n";
		
		for(PhoneNumber phoneNumber: phoneNumbers)
			output += phoneNumber.toString() + " \n";
		
		return output;
	}

}