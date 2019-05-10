
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Echristian1 {

	public static void main(String[] args) {
		String wannaContinue = "y";
		while (wannaContinue.equals("y") || wannaContinue.equals("Y")) {
			System.out.println("\nWhat do you want to do?");
			System.out.println("A – Append a personality test");
			System.out.println("B – Evaluate the unprocessed personality tests");
			System.out.println("C – Count and display how many people tested fell into each personality range");
			System.out.println("D – Quit");

			Scanner input = new Scanner(System.in);
			String choice = input.nextLine();

			if (choice.equals("A") || choice.equals("a")) {
				appendPersonalityTest();
			} else if (choice.equals("B") || choice.equals("b")) {
				evaluateTest();
			} else if (choice.equals("C") || choice.equals("c")) {
				countAndDisplay();
			}

			else if (choice.equals("D") || choice.equals("d")) {
				//input.close();
				System.exit(0);
			} else {
				System.out.println("Invalid Choice");
			}
			Scanner finalInput = new Scanner(System.in);
			System.out.println("Again ? y/n");
			wannaContinue=finalInput.next();
			
			
		}

	}

	public static void appendPersonalityTest() {
		try {
			String answer;
			Scanner keyboard = new Scanner(System.in);
			String strLine;

			BufferedWriter bw = new BufferedWriter(new FileWriter("UnprocssedTests.txt", true));

			BufferedReader br = new BufferedReader(new FileReader("questions.txt"));

			// accept name
			System.out.println("What is your name?: ");
			String name = keyboard.nextLine();
			bw.write(name + "\n");

			// read the questions
			int line_counter = 1;
			// as long as we are not on the end of file
			while ((strLine = br.readLine()) != null) {
				System.out.println(strLine);
				// if the line number is divisible by 5
				if (line_counter % 5 == 0) {
					// take keyboard input
					String theanswer;
					while (!"ABCD".contains((theanswer = keyboard.nextLine()))) {
						continue;
					}
					// write answer to file
					bw.write(theanswer + "\n");
				}
				line_counter++;
			}
			br.close();
			bw.close();
			//keyboard.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

	private static void evaluateTest() {
		String strLine;
		Scanner keyboard = new Scanner(System.in);

		// store question weights
		int[][] weights = { { 3, 1, 6, 2 }, { 2, 1, 3, 4 }, { 2, 1, 3, 4 }, { 3, 1, 2, 6 }, { 1, 2, 5, 3 },
				{ 3, 1, 4, 2 }, { 2, 1, 3, 4 }, { 4, 3, 2, 5 }, { 6, 4, 8, 2 }, { 7, 5, 1, 3 } };
		try {

			BufferedReader br = new BufferedReader(new FileReader("UnprocssedTests.txt"));
			BufferedWriter bw = new BufferedWriter(new FileWriter("resultTests.txt", true));

			int line_counter = 1;
			// used to store one attempt of the test
			ArrayList<String> attempt = new ArrayList<String>();
			// as long as we are not on the end of file
			while ((strLine = br.readLine()) != null) {

				attempt.add(strLine);
				// reached 11th line move to the next data
				if (line_counter % 11 == 0) {
					System.out.println("Read 11 lines");
					// write name
					bw.write(attempt.get(0) + "\n");
					// stores the total score
					int score = 0;
					// calculate the score for the current attempt
					// checks all 10 questions
					for (int i = 1; i <= 10; i++) {
						if (attempt.get(i).equals("A")) {
							score += weights[i - 1][0];
						} else if (attempt.get(i).equals("B")) {
							score += weights[i - 1][1];
						} else if (attempt.get(i).equals("C")) {
							score += weights[i - 1][2];

						} else if (attempt.get(i).equals("D")) {
							score += weights[i - 1][3];

						}

					}
					// write score
					if (score >= 12 && score <= 20)
						bw.write("Personality Type 1\n");
					else if (score >= 21 && score <= 30)
						bw.write("Personality Type 2\n");
					else if (score >= 31 && score <= 42)
						bw.write("Personality Type 3\n");
					else if (score >= 43 && score <= 53)
						bw.write("Personality Type 4\n");

					// print the status
					System.out.println("Info written to file");
					System.out.println(attempt.get(0) + " ");
					System.out.println(score);
					System.out.println();
					// clear the array
					attempt.clear();

				}
				line_counter++;

			}

			// clear unprocessed text file
			BufferedWriter forClearing = new BufferedWriter(new FileWriter("UnprocssedTests.txt", false));
			forClearing.close();

			//keyboard.close();
			br.close();
			bw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void countAndDisplay() {
		String strLine;
		int oneCounter = 0;
		int twoCounter = 0;
		int threeCounter = 0;
		int fourCounter = 0;
		try {
			BufferedReader br = new BufferedReader(new FileReader("resultTests.txt"));
			while ((strLine = br.readLine()) != null) {
				strLine = strLine.trim();
				if (strLine.equals("Personality Type 1")) {
					oneCounter++;
				} else if (strLine.equals("Personality Type 2")) {
					twoCounter++;
				} else if (strLine.equals("Personality Type 3")) {
					threeCounter++;
				} else if (strLine.equals("Personality Type 4")) {
					fourCounter++;
				}
			}

			System.out.println("Personality Type 1: " + oneCounter);
			System.out.println("Personality Type 2: " + twoCounter);
			System.out.println("Personality Type 3: " + threeCounter);
			System.out.println("Personality Type 4: " + fourCounter);

			br.close();

		}

		catch (IOException e) {
			e.printStackTrace();
		}

	}

}
