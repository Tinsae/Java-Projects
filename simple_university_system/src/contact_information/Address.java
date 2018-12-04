package contact_information;

public class Address {

	private int streetNumber;
	private int aptNumber;
	private String streetName;
	private String city;
	private String state;
	private int zipCode;

	public Address(int streetNumber, int aptNumber, String streetName, String city, String state, int zipCode) {
		this.streetNumber = streetNumber;
		this.aptNumber = aptNumber;
		this.streetName = streetName;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}

	public int getStreetNumber() {
		return streetNumber;

	}

	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}

	public int getAptNumber() {
		return aptNumber;
	}

	public void setAptNumber(int aptNumber) {
		this.aptNumber = aptNumber;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	public boolean equals(Address address) {
		return address.streetNumber == this.streetNumber &&
				address.aptNumber == this.aptNumber &&
				address.streetName.equalsIgnoreCase(this.streetName) &&
				address.city.equalsIgnoreCase(this.city) &&
				address.state.equalsIgnoreCase(this.state) &&
				address.zipCode == this.zipCode;
	}

	@Override
	public String toString() {
		return "\nStreet Number: " + streetNumber + "\nApartment Number: " + aptNumber +
				"\nStreet Name: " + streetName + "\nCity: " + city + "\nState: " + 
				state + "\nZip Code: " + zipCode;
	}
	
}