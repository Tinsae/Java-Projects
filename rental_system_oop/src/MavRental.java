/*Shumi Chowdhury*/

import java.util.*;
import java.io.*;
public class MavRental implements Invoice, Serializable
{	
	private ArrayList<Customer> customerList = new ArrayList<Customer>();
	
	public ArrayList<Customer> getCustomerList()
	{
		return customerList;
	}
	public void addCustomer(Customer c)
	{
		customerList.add(c);
	}
//change name to n
	public boolean customerExists(String n)
	{

		for(Customer c:customerList)
		{
			if(c.getName().equals(n))
				return true;
		}	
		return false;
	}
	
//needs editing
	public String printInvoice()
	{
		String message = "";
    
    		for(Customer c:customerList)
    		{	  
         		double total = 0.0;
        
   	 		for(Rental r: c.getRentalList())
    			{
        	
				total += r.calculateCharge();
   	 		}
	 		message = String.format("%s $%.2f\n", c.getName(),total);
    
   		}
   		return message;

  	}

	public String toString()
	{
		return("Customer List" + customerList);
	}
}
