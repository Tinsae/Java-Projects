package groupProject;
import java.util.ArrayList;
public class Course
{
 private String courseName;
 private String courseBuilding;
 private String courseBldgRoom;
 private int courseCapacity;
 private int courseID;
 private ArrayList<Student> enrolledStudents;
 private Instructor courseInstructor;
 private static int nextCourseID = 1;


    public Course(String name, String building, String room, int capacity) 
    {
        this.courseName = name + this.courseID;
        this.courseBuilding = building;
        this.courseBldgRoom = room;
        this.courseCapacity = capacity;
        this.courseID = nextCourseID;
        courseInstructor = null;
        this.enrolledStudents = new ArrayList<Student>(); //making an empty list of students
    }
    public void enrollStudent(Student newStudent)
    {
        if(this.enrolledStudents.size() <= this.courseCapacity)
            this.enrolledStudents.add(newStudent);
    }
    public boolean removeStudent(int studentID)
    {
        for(int i=0;i<enrolledStudents.size();i++)
        {
            if(this.enrolledStudents.get(i).getStudentID()== studentID)
            {
                this.enrolledStudents.remove(i);
                return true;
            }
        }
        return false;
    }
    public void assignInstructor(Instructor newInstr)
    {
        courseInstructor = newInstr;
    }
    public void setCourseBldgRoom(String room)
    {
        this.courseBldgRoom = room;
    }
    public void setCourseBuilding(String building)
    {
        this.courseBuilding = building;
    }
    public void setCapacity(int newCapacity)
    {
        this.courseCapacity = newCapacity;
    }
    public void setCourseName(String name)
    {
        this.courseName = name + this.courseID;
    }
    public String toString()
    {
        String str = "";
        str = "ID : " + courseID + " Name : " + courseName + " Building : "+ 
        courseBuilding +" Room : "+ courseBldgRoom + " Capacity : " + courseCapacity;
        if(courseInstructor != null)
           str += " Instructor : "+ courseInstructor.getTitle();
        return str;
    }
    public String getRoster()
    {
      if(enrolledStudents.size() == 0)
         return "No Students enrolled in this course";
      else
        {
          String str = "Students enrolled in this course : \n";
          for(int i=0;i<enrolledStudents.size();i++)
              str += "ID : " + enrolledStudents.get(i).getStudentID()+ " Name : "+enrolledStudents.get(i).getName()+"\n";
          return str;
        }
    }
}
