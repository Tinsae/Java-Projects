/*Shumi Chowdhury*/

import java.io.*;


public class FurnitureRental extends Rental implements Serializable
{
	public enum FurnitureType{BED, COUCH, CHAIR};
	private FurnitureType fType;
	
	public FurnitureRental()
	{
		super();
	}
	public FurnitureRental( FurnitureType ft,double p, int nd )
	{
		super(p, nd);
		setFType(ft);
	}
	public void setFType(FurnitureType ft)
	{
		fType = ft;
	}
	public FurnitureType getFType()
	{
		return fType;
	}
	public String toString()
	{
		return("Furniture Type" + fType);
	}
	public double calculateCharge()
	{
		return getPricePerDay() * getNumberOfDays() * (.95);
	}
}