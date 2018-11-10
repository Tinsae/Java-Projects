/*Shumi Chowdhury*/

import java.io.*;
import java.util.*;



public class Customer implements Serializable
{
	/*Setting the variables*/
	private String name;
	private Address address;
	private String creditCardNumber;
	private ArrayList<Rental> rentalList = new ArrayList<Rental>();

/*constructors*/	
	public Customer()
	{
		setName("");
		setCreditCardNumber("");
		setAddress(new Address("","","",""));
	}
	public Customer(String n, Address a, String cc)
	{
		setName(n);
		setAddress(new Address("","","",""));
		setCreditCardNumber(cc);
	}
	public void setName(String n)
	{
		name = n;
	}
	public void setAddress(Address a)
	{
		address = a;
	}
	public void setCreditCardNumber(String cc)
	{
		creditCardNumber = cc;
	}
	public String getName()
	{
		return name;
	}
	public Address getAddress()
	{
		return address;
	}
	public String getCreditCardNumber()
	{
		return creditCardNumber;
	}
	public ArrayList<Rental> getRentalList()
	{
		return rentalList;
	}
	public void addRental(Rental r)
	{
		rentalList.add(r);
	}
	public String toString()
	{
		return("Name" + name + "Address" + address + "Credit Card Number" + creditCardNumber + "Rental List" + rentalList);
	}
}