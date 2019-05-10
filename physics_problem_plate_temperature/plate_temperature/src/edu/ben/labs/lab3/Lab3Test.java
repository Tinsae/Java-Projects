package edu.ben.labs.lab3;

import java.io.File;
import java.text.DecimalFormat;

public class Lab3Test {

	public static void main(String[] args) {
		// decimal formatter
		DecimalFormat twoDForm = new DecimalFormat("#.##");
		// 0 will displayed as 0.00
		twoDForm.setMinimumFractionDigits(2);
		File f = new File("plates_data.txt");
		Plate[] returnedPlates = Lab3.processTempsFromFile(f, 2);

		// the first plate in the array of plates
		Plate p1 = returnedPlates[0];
		// the second plate
		Plate p2 = returnedPlates[1];

		// print the plate grid
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 12; j++) {
				// formatted output
				// - is for left alignment
				System.out.printf("%-6s ", twoDForm.format(p1.plateGrid[i][j]));
				//System.out.print(twoDForm.format(p1.plateGrid[i][j]) + "\t");
			
			}
			System.out.println();
		}
//		print another plate
//		System.out.println("\n\n");
//		// print the plate grid
//		for (int i = 0; i < 12; i++) {
//			for (int j = 0; j < 12; j++) {
//				System.out.print(p2.plateGrid[i][j] + " ");
//
//			}
//			System.out.println();
//		}

	}

}
