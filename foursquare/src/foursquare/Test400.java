package foursquare;

import java.util.ArrayList;
import java.util.Collections;

public class Test400
{
   public static void main(String [] args)
   {
   // Create a 10 x 10 array of characters
   //fill top left matrix
   	char[][] matrix = new char[10][10];
  // (0,0) - (4,4) fill with letters from a - z
    char letter = 'a';
    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
            if (letter == 'q') {
					letter++;
				}
            matrix[i][j] = letter;
            letter ++;
        }
    }
    // fill bottom right matrix
    // (5,5) - (9,9) fill with letters from a - z
	letter = 'a';
    for (int i = 5; i < 10; i++) {
        for (int j = 5; j < 10; j++) {
            if (letter == 'q') {
					letter++;
				}
            matrix[i][j] = letter;
            letter ++;
            }
    }
    // create an array list containing all the english capital letters
	// except q
	char cLetter = 'A';
	ArrayList<Character> letters = new ArrayList<Character>();
    for (int i = 0; i < 25; i++) {
        if (cLetter == 'Q') {
            cLetter++;
            }
		letters.add(cLetter);
		cLetter++;
	}
	// (0,5) - (4,9) fill unique letters from A - Z
		Collections.shuffle(letters);
		int counter = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 5; j < 10; j++) {
				cLetter = letters.get(counter);
				matrix[i][j] = letters.get(counter);
				counter++;

			}
		}
	// (5,0) - (9,4) fill unique letters from A - Z
		Collections.shuffle(letters);
		counter = 0;
		for (int i = 5; i < 10; i++) {
			for (int j = 0; j < 5; j++) {
				cLetter = letters.get(counter);
				matrix[i][j] = letters.get(counter);
				counter++;
			}
		}
        
        // display the full array
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
   }
}
