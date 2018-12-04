import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

import contact_information.*;
import people.*;
import university_database.*;

public class DatabaseFileIO {
	public static String readCSV(File inFile) {
        try {
        	Scanner fReader = new Scanner(inFile);
        	String output= "";
            while(fReader.hasNextLine()) {
                String nextLine = fReader.nextLine();
                String[] splitLine = nextLine.split(",");
               // conctenate strings together
                // \n is for newline
                output += nextLine + "\n";
            }
            return output;
        }
        // return nothing if file is not found
        catch (FileNotFoundException ex) {
        	return "";
        }
    }

	public static void fileWrite() {
	        String outFile = "database_output.txt";
	        PrintWriter writer = null;
	        try {
	            writer = new PrintWriter(outFile);
	        }
	        catch (IOException ex) {
	        }
	        Database db = new Database();
	        Address address = new Address(1824, 0, "Gage Avenue", "Los Angeles", "CA", 91104);
			Address address1 = new Address(2513, 0, "Gleason Street", "Los Angeles", "CA", 94567);
			Address address2 = new Address(7513, 0, "Fourth Street", "Los Angeles", "CA", 93457);
			Address address3 = new Address(2345, 0, "Boyle Avenue", "Los Angeles", "CA", 91346);
			Address address4 = new Address(1137, 2, "Alma Street", "Los Angeles", "CA", 99674);
			Address address5 = new Address(9845, 0, "Saint Louis", "Los Angeles", "CA", 94578);
			Address address6 = new Address(6386, 0, "Mednik Avenue", "Los Angeles", "CA", 97456);
			Address address7 = new Address(9464, 0, "Paramount Street", "Montebello", "CA", 94565);
			Address address8 = new Address(3098, 4, "Milton Street", "Montebello", "CA", 91256);
			Address address9 = new Address(2856, 0, "Indian Street", "Montebello", "CA", 94568);
			Address address10 = new Address(1666, 0, "Bourbon Street", "Montebello", "CA", 91446);
	        
			PhoneNumber[] phoneNumbers = { new PhoneNumber("Home: ", 323, 378, 1991),
					new PhoneNumber("Cell: ", 323, 755, 1836) };
			PhoneNumber[] phoneNumbers1 = { new PhoneNumber("Home: ", 323, 846, 3489) };
			PhoneNumber[] phoneNumbers2 = { new PhoneNumber("Home: ", 323, 174, 8975) };
			PhoneNumber[] phoneNumbers3 = { new PhoneNumber("Home: ", 323, 198, 9875),
					new PhoneNumber("Work: ", 323, 454, 1847) };
			PhoneNumber[] phoneNumbers4 = { new PhoneNumber("Home: ", 323, 936, 5388) };
			PhoneNumber[] phoneNumbers5 = { new PhoneNumber("Home: ", 323, 273, 1908) };
			PhoneNumber[] phoneNumbers6 = { new PhoneNumber("Home: ", 323, 384, 1936) };
			PhoneNumber[] phoneNumbers7 = { new PhoneNumber("Home: ", 323, 183, 1651) };
			PhoneNumber[] phoneNumbers8 = { new PhoneNumber("Home: ", 323, 072, 0373),
					new PhoneNumber("Cell: ", 323, 468, 3947) };
			PhoneNumber[] phoneNumbers9 = { new PhoneNumber("Home: ", 323, 382, 3984) };
			PhoneNumber[] phoneNumbers10 = { new PhoneNumber("Home: ", 323, 936, 3408) };
			
			Faculty faculty = new Faculty("Arthur", "Cardona", "arthc12@calstatela.edu", address, phoneNumbers, "E&T 228",
					55000, "M&W: 3:30", "Professor");

			Staff staff = new Staff("Josh", "Zielinski", "joshz57@calstatela.edu", address1, phoneNumbers1, "E&T 311",
					38000, "Librarian");

			Student student = new Student("Edgar", "Hernandez", "ehern251@calstatela.edu", address2, phoneNumbers2,
					"freshman");

			Faculty faculty2 = new Faculty("Jacod", "Valdez", "jvald45@calstatela.edu", address3, phoneNumbers3, "FA 546",
					42000, "T&TH: 12:30", "Professor");

			Staff staff2 = new Staff("Susan", "Romero", "srome90@calstatela.edu", address4, phoneNumbers4, "FA 342", 50000,
					"School Nurse");

			Student student2 = new Student("Elias", "Gomez", "egomez5@calstatela.edu", address5, phoneNumbers5, "senior");
			Faculty faculty3 = new Faculty("Marissa", "Cortez", "macort11@calstatela.edu", address6, phoneNumbers6,
					"SH 173", 62000, "M: 5:45", "Professor");

			Staff staff3 = new Staff("Mark", "Delmis", "mdelm75@calstatela.edu", address7, phoneNumbers7, "SH 176", 38000,
					"Therapist");

			Student student3 = new Student("Fred", "Alcantar", "falca35@calstatela.edu", address8, phoneNumbers8, "junior");

			Faculty faculty4 = new Faculty("Ruby", "Gonzalez", "rgonz654@calstatela.edu", address9, phoneNumbers9,
					"E&T 228", 72000, "F: 1:00", "Professor");

			Staff staff4 = new Staff("Ray", "Donovan", "rdono786@calstatela.edu", address10, phoneNumbers10, "FA 355",
					46500, "Food Server");
			
			faculty.toString();
			
			db.add(faculty);
			db.add(staff);
			db.add(student);
			db.add(faculty2);
			db.add(staff2);
			db.add(student2);
			db.add(faculty3);
			db.add(staff3);
			db.add(student3);
			db.add(faculty4);
			db.add(staff4);
			
			writer.println(faculty);
			writer.println(staff);
			writer.println(student);
			writer.println(faculty2);
			writer.println(staff2);
			writer.println(student2);
			writer.println(faculty3);
			writer.println(staff3);
			writer.println(student3);
			writer.println(faculty4);
			writer.println(staff4);
			
	        writer.flush();
	        writer.close();
	        
	        System.out.println("Done.");
	}
}