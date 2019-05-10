package groupProject;

import java.util.ArrayList;

public class Instructor {

    private String name;
    private String prefix;
    private String officeLocation;
    private String department;
    private String email;
    //public static ArrayList instructorList = new ArrayList<Instructor>();
    private int instructorID;
    private static int nextInstructorID = 0;
    
    public Instructor(String name, String prefix, String office, String dept, String email) {
        this.name = name;
        this.prefix = prefix;
        this.officeLocation = office;
        this.department = dept;
        this.instructorID = nextInstructorID++;
        
        //set e-mail
         for (int i = 0; i < email.length(); i++){
            if (email.charAt(i) == '@')
               this.email = email;
            else
                System.out.println("Error! Needs a @");   
    	}
    		// instructorList.add(this);
    }		
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
    
    public void setDepartment(String dept) {
        this.department = dept;
    }
    
    public void setEmail(String email) {
        for (int i = 0; i < email.length(); i++){
            if (email.charAt(i) == '@')
               this.email = email;
            else
                System.out.println("Error! Needs a @");
    
    }
    }
    
    public void setOfficeLocation(String office) 
    {
        this.officeLocation = office;
    }
    
    public String getTitle() {
        return this.prefix;
    }
    
    public String toString() {
        String tempStr = "";
        tempStr = "Instructors Name: " + this.name + "\nDepartmment: " + this.department +
                "\nOffice Location: " + this.officeLocation + "\nEmail: " + this.email;
        return tempStr;
              
    }
 }
