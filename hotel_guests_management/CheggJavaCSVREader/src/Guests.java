import java.io.BufferedReader;
import java.io.FileReader;

// The Guests Class will have the following:
// 1. Nine class variables for the 6-9 values collected for each object. Note: The full name will go in one class variable, but the
// city and state will go in separate class variables.

// 2. Create 4 constructor methods. This is accomplished via method overloading (explained in Chapter 7).
// a. One constructor method will accept 6 parameters in this order- primary family members name, street address, city,
// state, number of guests, room number
// b. One constructor method will accept 7 parameters in this order- primary family members name, street address, city,
// state, number of guests, room number, guest #2’s first name
// c. One constructor method will accept 8 parameters in this order- primary family members name, street address, city,
// state, number of guests, room number, guest #2’s first name, guest #3’s first name
// d. One constructor method will accept 9 parameters in this order- primary family members name, street address, city,
// state, number of guests, room number, guest #2’s first name, guest #3’s first name, guest #4’s first name
// *Note: If there isn’t a guest #2 or guest #3 or guest #4 for a room, their name will remain null for the object.
// 3. A toString method that will print out the primary family members name, city, state, and room# for the object . Also make sure
// to include labels describing the data…like Name: Paul Murray……

public class Guests {

// nine class variables
	private String primaryFamilyMembersName;
	private String streetAddress;
	private String city;
	private String state;
	private int numberOfGuests;
	private String secondGuestName;
	private String thirdGuestName;
	private String fourthGuestName;
	private int roomNumber;

// Full Name of the primary family member (stored as one value)
// ii. Street Address
// iii. City (as a separate value from the State)
// iv. State
// v. Number of guests in the room (including the primary family member)
// vi. The first name only of all additional guests in the room. Since there is a max occupancy of 4 per room, this
// may be a list of 0-3 more names.
// vii. Room# (Room number are from 101 to 134)-the program will be responsible for assigning each guest family
// a room. 
// The first family will go in room 101, 
// the second in room 102, etc. This room number will not be in
// the text file, your program will need to do this. I would recommend incorporating a loop counter like taking
// 100+1 and then 100+2, etc. 
// 2. Create 4 constructor methods. 
// This is accomplished via method overloading (explained in Chapter 7).
// a. One constructor method will accept 6 parameters in this order- primary family members name, street address, city,
// state, number of guests, room number
// b. One constructor method will accept 7 parameters in this order- primary family members name, street address, city,
// state, number of guests, room number, guest #2’s first name
// c. One constructor method will accept 8 parameters in this order- primary family members name, street address, city,
// state, number of guests, room number, guest #2’s first name, guest #3’s first name
// d. One constructor method will accept 9 parameters in this order- primary family members name, street address, city,
// state, number of guests, room number, guest #2’s first name, guest #3’s first name, guest #4’s first name
// *Note: If there isn’t a guest #2 or guest #3 or guest #4 for a room, their name will remain null for the object.

	public Guests(String primaryFamilyMembersName, String streetAddress, String city, String state, int numberOfGuests,
			int roomNumber) {
		this.primaryFamilyMembersName = primaryFamilyMembersName;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.numberOfGuests = numberOfGuests;
		this.roomNumber = roomNumber;

	}

// primary family members name, street address, city,
// state, number of guests, room number, guest #2’s first name
	public Guests(String primaryFamilyMembersName, String streetAddress, String city, String state, int numberOfGuests,
			int roomNumber, String secondGuestName) {
		this.primaryFamilyMembersName = primaryFamilyMembersName;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.numberOfGuests = numberOfGuests;
		this.roomNumber = roomNumber;
		this.secondGuestName = secondGuestName;

	}

	public Guests(String primaryFamilyMembersName, String streetAddress, String city, String state, int numberOfGuests,
			int roomNumber, String secondGuestName, String thirdGuestName) {
		this.primaryFamilyMembersName = primaryFamilyMembersName;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.numberOfGuests = numberOfGuests;
		this.roomNumber = roomNumber;
		this.secondGuestName = secondGuestName;
		this.thirdGuestName = thirdGuestName;

	}

	public Guests(String primaryFamilyMembersName, String streetAddress, String city, String state, int numberOfGuests,
			int roomNumber, String secondGuestName, String thirdGuestName, String fourthGuestName) {
		this.primaryFamilyMembersName = primaryFamilyMembersName;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.numberOfGuests = numberOfGuests;
		this.roomNumber = roomNumber;
		this.secondGuestName = secondGuestName;
		this.thirdGuestName = thirdGuestName;
		this.fourthGuestName = fourthGuestName;

	}
	
	
// A toString method that will print 
// out the primary family members name, city, state, 
// and room# for the object . Also make sure
// to include labels describing the data…like Name: Paul Murray……

public String toString()
{
    String output = "";
    output += "Name: " + primaryFamilyMembersName + "\n";
    output += "City: " + city + "\n";
    output += "State: " + state + "\n";
    output += "Room#: " + roomNumber + "\n";

    return output;   
}





}
