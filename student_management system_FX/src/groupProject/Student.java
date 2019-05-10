package groupProject;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {
	private String firstName;
	private String lastName;
	private String studentYear;
	private String studentMajor;
	private double GPA;
	private String studentEmail;
	private int studentID;
	private int nextStudentID = 0;
	// public static ArrayList studentList = new ArrayList<Student>();

	public Student(String name, int year, String major, double GPA, String email) {
		// add student to Student Array
		// studentList.add(this);
		// set Name
		if (name != null) {
			if (name.length() == 2) {
				this.firstName = name.split("")[0];
				this.lastName = name.split("")[1];
			} else {
				System.out.println("Invalid name format, enter [firstname lastname]");
			}
		}

		// name = this.firstName + this.lastName;
		this.studentYear = "" + year;
		this.studentMajor = major;
		this.GPA = GPA;
		this.studentEmail = email;

		// set GPA
		if (GPA <= 5.0 && GPA >= 0.0)
			this.GPA = GPA;
		else
			System.out.println("Error!");

		// set year
		switch (year) {
		case 1:
			this.studentYear = "Freshman";
		case 2:
			this.studentYear = "Sophomore";
		case 3:
			this.studentYear = "Junior";
		case 4:
			this.studentYear = "Senior";
		}
		this.studentMajor = major;
		this.studentID = nextStudentID++;
	}

	public void setGPA(double GPA) {
		if (GPA <= 5.0 && GPA >= 0.0)
			this.GPA = GPA;
		else
			System.out.println("Error!");
	}

	public double getGPA() {
		return this.GPA;
	}

	public String getName() {
		return this.firstName + this.lastName;
	}

	public void setName(String name) {

		this.firstName = name.split("")[0];
		this.lastName = name.split("")[1];

	}

	public void getName(String text) {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
																		// Tools | Templates.
	}

	public int getStudentID() {
		return this.studentID;
	}

	public void setStudentEmail(String email) {
		Pattern email_validator = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
				Pattern.CASE_INSENSITIVE);

		Matcher matcher = email_validator.matcher(email);
		if (matcher.find()) {
			this.studentEmail = email;
		} else {
			System.out.println("Invalid email address");

		}

// 		for (int i = 0; i < email.length(); i++) {
// 			if (email.charAt(i) == '@')
// 				this.studentEmail = email;
// 			else
// 				System.out.println("Error! Needs a @");
// 		}

	}

	public String getStudentYear() {
		return this.studentYear;
	}

	public void setStudentYear(int year) {
		switch (year) {
		case 1:
			this.studentYear = "Freshman";
		case 2:
			this.studentYear = "Sophomore";
		case 3:
			this.studentYear = "Junior";
		case 4:
			this.studentYear = "Senior";
		}
	}

	public String getStudentMajor() {
		return this.studentMajor;
	}

	public void setStudentMajor(String major) {
		this.studentMajor = major;
	}

}
