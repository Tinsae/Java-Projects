package foursquare;

public class Test1000 {

	public static void main(String[] args) {
		// Get the string to be encrpyted
		String phrase = "THREE FIFTY";
		
		phrase = "THANKS GIVING DAY";
        /*	System.out.println(phrase);
		phrase = 
		phrase.substring(0, 5) + phrase.substring(6);
		System.out.println(phrase)
		*/
		// remove spaces
		phrase = phrase.replaceAll("\\s", "");
		System.out.println(phrase);
		

	}

}
