/*Shumi Chowdhury*/

public class Address
{
	private String street;
	private String state;
	private String city;
	private String zip;

	public Address()
	{
		setStreet("");
		setState("");
		setCity("");
		setZip("");
	}
	public Address( String st, String s, String c, String z)
	{
		setStreet(st);
		setState(s);
		setCity(c);
		setZip(z);
	}
	public void setStreet(String st)
	{
		street = st;
	}
	public  void setState(String s)
	{
		state = s;
	}
	public void setCity(String c)
	{
		city = c;
	}
	public void setZip(String z)
	{
		zip = z;
	}
	public String getStreet()
	{
		return street;
	}
	public String getState()
	{
		return state;
	}
	public String getCity()
	{
		return city;
	}
	public String getZip()
	{
		return zip;
	}
	public String toString()
	{
		return("Street" + street + "State" + state + "City" + city + "Zip" + zip);
	}
}