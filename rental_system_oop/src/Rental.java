/*Shumi Chowdhury*/

import java.io.*;

public abstract class Rental
{
	private double pricePerDay;
	private int numberOfDays;
	
	public Rental()
	{
		setPricePerDay(0.0);
		setNumberOfDays(0);
	}
	public Rental( double p, int nd)
	{
		setPricePerDay(p);
		setNumberOfDays(nd);
	}
	public void setPricePerDay(double p)
	{
		pricePerDay = p;
	}
	public void setNumberOfDays(int nd)
	{
		numberOfDays = nd;
	}
	public double getPricePerDay()
	{
		return pricePerDay;
	}
	public int getNumberOfDays()
	{
		return numberOfDays;
	}
	public String toString()
	{
		return("Price Per Day" + pricePerDay + "Number Of Days" + numberOfDays);
	}
	public abstract double calculateCharge();

}
