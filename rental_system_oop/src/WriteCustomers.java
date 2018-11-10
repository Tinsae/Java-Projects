/*Shumi Chowdhury*/

import java.io.*;
import java.util.*;

public class WriteCustomers
{
	public static void main(String args[])
	{
		Formatter output;
		try
		{
			output = new Formatter(new File("customers.txt"));
			output.format("%s,%s,%s,%s,%s,%s,%s,%s,%.2f,%d%n","Jones","123 Mitchell", "Arlington","Texas","76019","1222-4567-3456-1111", "Furniture", "COUCH",25.00,4);
			output.format("%s,%s,%s,%s,%s,%s,%s,%s,%.2f,%d%n","Smith", "61 Bose Lane","Dallas","Texas","75000", "6547-2341-5445-3456", "Electronic", "TV", 35.50,14);

			output.format("%s,%s,%s,%s,%s,%s,%s,%s,%.2f,%d%n","Willis", "245 Monster Drive", "Hurst", "Texas","75050", "4156-3456-1111-2222","Furniture", "BED", 15.75, 7);
			output.format("%s,%s,%s,%s,%s,%s,%s,%s,%.2f,%d%n","Jones", "123 Mitchell", "Arlington", "Texas","76019", "5222-4567-3456-1111","Electronic","COMPUTER", 30.00,5);
 
			output.format("%s,%s,%s,%s,%s,%s,%s,%s,%.2f,%d%n","Smith","61 Bose Lane","Dallas","Texas", "75000", "6547-2341-5445-3456", "Electronic", "COMPUTER", 45.00, 3);

			output.close();
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
	}
}