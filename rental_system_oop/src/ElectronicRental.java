/*Shumi Chowdhury*/

import java.io.*;
public class ElectronicRental extends Rental implements Serializable
{
	public enum ElectronicType{COMPUTER, TV};
	private ElectronicType eType;

	public ElectronicRental()
	{
		super();
	}
	public ElectronicRental( ElectronicType et, double p, int nd)
	{
		super(p, nd);
		setEType(et);
	}
	public void setEType(ElectronicType et)
	{
		eType = et;
	}
	public ElectronicType getEType()
	{
		return eType;
	}
	public String toString()
	{
		return("Electronic Type" + eType);
	}

	public double calculateCharge()
	{
		return getPricePerDay() * getNumberOfDays() * (1.15);
	}
}
	
