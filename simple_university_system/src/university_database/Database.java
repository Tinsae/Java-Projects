package university_database;

import java.util.ArrayList;
import java.util.Scanner;

import people.Employee;
import people.Faculty;
import people.Person;
import people.Staff;
import people.Student;

public class Database extends ArrayList<Person> {

	public Database() {
		super();
	}

	public void printDatabase() {
		for (Person person : this) {
			System.out.println(person.toString());
		}
	}

	public void printDatabase(String type) {
		for (Person person : this) {
			if (type.equalsIgnoreCase("employee")) {
				if (person instanceof Employee) {
					System.out.println(person.toString());
				}
			} else if (type.equalsIgnoreCase("faculty")) {
				if (person instanceof Faculty) {
					System.out.println(person.toString());
				}
			} else if (type.equalsIgnoreCase("staff")) {
				if (person instanceof Staff) {
					System.out.println(person.toString());
				}
			} else if (type.equalsIgnoreCase("student")) {
				if (person instanceof Student) {
					System.out.println(person.toString());
				}
			} else {
				System.out.println("Invalid parameter input. Please enter valid type.");
			}
		}
	}

	public int getNumberOfPeople() {
		int count = 0;

		for (Person person : this) {
			count++;
		}

		return count;
	}

	public int getNumberOfStudents() {
		int count = 0;

		for (Person person : this) {
			if (person instanceof Student) {
				count++;
			}
		}

		return count;
	}

	public int getNumberOfEmployees() {
		int count = 0;

		for (Person person : this) {
			if (person instanceof Employee) {
				count++;
			}
		}

		return count;
	}

	public int getNumberOfStaff() {
		int count = 0;

		for (Person person : this) {
			if (person instanceof Staff) {
				count++;
			}
		}

		return count;
	}

	public int getNumberOfFaculty() {
		int count = 0;

		for (Person person : this) {
			if (person instanceof Faculty) {
				count++;
			}
		}

		return count;
	}

	public int getNumberOfStudentsByClassStanding(String classStanding) {
		int count = 0;

		for (Person person : this) {
			if (person instanceof Student) {
				Student student = (Student) person;
				if (student.getClassStanding().equalsIgnoreCase(classStanding)) {
					count++;
				}
			}
		}

		return count;
	}

	public int displayEmployeesGreaterThanSalary(double salary) {
		int count = 0;

		for (Person person : this) {
			if (person instanceof Employee) {
				Employee employee = (Employee) person;
				if (employee.getSalary() > salary) {
					count++;
				}
			}
		}

		return count;
	}

	public int displayEmployeesEqualToSalary(double salary) {
		int count = 0;

		for (Person person : this) {
			if (person instanceof Employee) {
				Employee employee = (Employee) person;
				if (employee.getSalary() == salary) {
					count++;
				}
			}
		}

		return count;
	}

	public int displayEmployeesLessThanSalary(double salary) {
		int count = 0;

		for (Person person : this) {
			if (person instanceof Employee) {
				Employee employee = (Employee) person;
				if (employee.getSalary() < salary) {
					count++;
				}
			}
		}

		return count;
	}
	
	public void addPerson(Person person) {
		super.add(person);
	}
	
	public Person findPerson(String fullName) {
		int matches = 0;
		for(Person person: this) {
			if(person.getName().equalsIgnoreCase(fullName)) {
				matches++;
				return person;
			}
		}
		if(matches <= 0) {
			System.out.println("There is no person with this name.\n");
		}
		return null;
	}
	
	public void removePerson(String fullName) {
		remove(findPerson(fullName));
	}
}

