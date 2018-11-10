
public class Teset1000 {

	public static void main(String [] args)
	{
		
		float [] bases = {3.5f, 5f, 1.25f,2f};
		int [] exponents = {64, 15, 31, 17};
		
		for(int i = 0; i < 4; i++)
		{
			System.out.format(bases[i] + " ^ " + exponents[i] +": %1.16e      %1.16e %n", 
					power(bases[i], exponents[i]), power_fast(bases[i], exponents[i]));
		}

	}
	// slow technique
	public static float power(float x, int n)
	{
		if(n == 0)
		{
			return 1;
		}
		else
		{
		    return ( x * power(x, n-1));
 
		}
	}
	//fast technique
	public static float power_fast(float x, int n)
	{
		if(n == 0)
		{
			return 1;
		}
		else if(n % 2 != 0)
		{
		    return ( x * power_fast(x, n-1));
 
		}
		else
		{
			float y = power_fast(x, n/2);  
			return y * y;
		}
	}

}
