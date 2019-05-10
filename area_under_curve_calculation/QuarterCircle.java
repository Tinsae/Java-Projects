package javajavaChegg;

public class Square {

	
	public static void main(String [] args)
	{
		int count = 0;
		// https://math.stackexchange.com/questions/198764/how-to-know-if-a-point-is-inside-a-circle
		for(int i=0; i < 10000; i++)
		{
		double x = Math.random();
		double y = Math.random();
		
		double d = Math.sqrt((y - 0) * (y - 0) + (x - 0) * (x - 0));
		
		// if it is within the circle
		if(d < 1)
		{
			count+=1;
		}
		}
		
	System.out.println(count/ 10000.);
	}
}
