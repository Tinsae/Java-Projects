package foursquare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class FourSquareCipher {

	public static void main(String[] args) {
		// Create a 10 x 10 array of characters
		char[][] matrix = new char[10][10];

		// (0,0) - (4,4) fill with letters from a - z
		char letter = 'a';
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (letter == 'q') {
					letter++;
				}
				matrix[i][j] = letter;
				letter++;

			}
		}
		// (5,5) - (9,9) fill with letters from a - z
		letter = 'a';
		for (int i = 5; i < 10; i++) {
			for (int j = 5; j < 10; j++) {
				if (letter == 'q') {
					letter++;
				}
				matrix[i][j] = letter;
				letter++;

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

		// Get the string to be encrypted
		String phrase = "THREE FIFTY";
		// remove spaces
		phrase = phrase.replaceAll("\\s", "");
		// find the length
		int length = phrase.length();
		// if length is not even, add Z to the end
		if (length % 2 != 0) {
			phrase += "Z";
		}
		// find the length again
		length = phrase.length();
		// find length of the digram
		int lenDi = length / 2;
		// declare array of strings to hold the digram
		String[] digrams = new String[lenDi];
		// create the digram using loop
		for (int i = 0; i < phrase.length() / 2; i++) {
			digrams[i] = phrase.substring(2 * i, (2 * i) + 2);
		}
		System.out.print("Digram : ");
		for (int i = 0; i < digrams.length; i++) {
			System.out.print(digrams[i] + " ");
		}
		System.out.println();

		// create an empty string encrypted
		String encrypted = "";
		for (String each : digrams) {
			char firstLetter = each.toLowerCase().toCharArray()[0];
			char secondLetter = each.toLowerCase().toCharArray()[1];

			// the position of the firstletter in the top left matrix
			int row1 = -1, column1 = -1;
			// the positon of the second letter in the bottom right matrix
			int row2 = -1, column2 = -1;

			// find first letter's position in the top left matrix
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (firstLetter == matrix[i][j]) {
						row1 = i;
						column1 = j;
					}

				}
			}
			// find second letter's position in the bottom right matrix
			for (int i = 5; i < 10; i++) {
				for (int j = 5; j < 10; j++) {
					if (secondLetter == matrix[i][j]) {
						row2 = i;
						column2 = j;
					}
				}
			}
			// the first encrypted letter = (row1, column2)
			// the second encrypted letter = (row2, column1)
			char firstEncrypted = matrix[row1][column2];
			char secondEncrypted = matrix[row2][column1];
			encrypted += firstEncrypted;
			encrypted += secondEncrypted;
		}
		System.out.println("encrypted = " + encrypted);

		// decrypt

		// find the length again
		length = encrypted.length();
		// find length of the edigram
		int lenEdi = length / 2;
		// declare array of strings to hold the eDigram
		String[] eDigrams = new String[lenDi];
		// create the digram using loop
		for (int i = 0; i < length / 2; i++) {
			eDigrams[i] = encrypted.substring(2 * i, (2 * i) + 2);
		}

		// create an empty string encrypted
		String decrypted = "";
		for (String each : eDigrams) {
			// here don't convert to lower case, because
			// the top right and bottom left matrices contain letters in upper case
			char firstLetter = each.toCharArray()[0];
			char secondLetter = each.toCharArray()[1];

			// the position of the firstletter in the top right matrix
			int row1 = -1, column1 = -1;
			// the positon of the second letter in the bottom left matrix
			int row2 = -1, column2 = -1;

			// find first letter's position in the top right matrix
			for (int i = 0; i < 5; i++) {
				for (int j = 5; j < 10; j++) {
					if (firstLetter == matrix[i][j]) {
						row1 = i;
						column1 = j;
					}

				}
			}
			// find second letter's position in the bottom left matrix
			for (int i = 5; i < 10; i++) {
				for (int j = 0; j < 5; j++) {
					if (secondLetter == matrix[i][j]) {
						row2 = i;
						column2 = j;
					}

				}
			}
			// the first decrypted letter = (row1, column2)
			// the second decrpyted letter = (row2, column1)
			char firstDecrypted = matrix[row1][column2];
			char secondDecrypted = matrix[row2][column1];
			decrypted += firstDecrypted;
			decrypted += secondDecrypted;
		}

		System.out.println("decrypted = " + decrypted.toUpperCase());

	}

}
