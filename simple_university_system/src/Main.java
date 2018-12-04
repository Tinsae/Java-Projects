
import java.util.Scanner;

import contact_information.Address;
import contact_information.PhoneNumber;
import people.Employee;
import people.Faculty;
import people.Person;
import people.Staff;
import people.Student;
import university_database.Database;

public class Main {

	public static void main(String[] args) {
		Database db = new Database();
		System.out.println("University Database:\n");
		db.printDatabase();

		System.out.println("PRINT TYPE:");
		db.printDatabase("faculty");
		db.printDatabase("student");
		db.printDatabase("staff");

		System.out.println("# People: " + db.getNumberOfPeople());

		System.out.println("# Employees: " + db.getNumberOfEmployees());

		System.out.println("# Faculty: " + db.getNumberOfFaculty());

		System.out.println("# Staff: " + db.getNumberOfStaff());

		System.out.println("# Students: " + db.getNumberOfStudents());

		String classStanding = "freshman";
		System.out.println("# Students(" + classStanding + "): " + db.getNumberOfStudentsByClassStanding(classStanding));

		String classStanding1 = "sophmore";
		System.out.println(
				"# Students(" + classStanding1 + "): " + db.getNumberOfStudentsByClassStanding(classStanding1));

		String classStanding2 = "junior";
		System.out.println(
				"# Students(" + classStanding2 + "): " + db.getNumberOfStudentsByClassStanding(classStanding2));

		String classStanding3 = "senior";
		System.out.println(
				"# Students(" + classStanding3 + "): " + db.getNumberOfStudentsByClassStanding(classStanding3));

		String classStanding4 = "graduate";
		System.out.println(
				"# Students(" + classStanding4 + "): " + db.getNumberOfStudentsByClassStanding(classStanding4));
		double salary = 40000.00;
		System.out.println("# Employees > Salary: " + db.displayEmployeesGreaterThanSalary(salary));
		System.out.println("# Employees = Salary: " + db.displayEmployeesEqualToSalary(salary));
		System.out.println("# Employees < Salary: " + db.displayEmployeesLessThanSalary(salary));
		
		new Menu(db);
	}
}
