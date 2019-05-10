package cscd210Utils;

import java.io.File;

public class Test {

	public static void main(String[] args) {

		File f = new File("c:/sample.txt");
		if(f.exists())
		{
			System.out.println("yes");
		}
		else
			System.out.println("No");
		
	}

}
