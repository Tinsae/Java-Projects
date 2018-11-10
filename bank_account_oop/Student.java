/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Yim
 */
//A Student has all the behaviors and properties of a Person
public class Student extends Person{
    protected int sId;
    protected String school;
    
    public Student(int id, String name, String school, int sId)
    {
         super(id, name);
         this.sId = sId;
         this.school = school;   //your code here
    }
    public String getSchool()
    {
        return school; //your code here
    }
    public int getSId()
    {
        return sId; //your code here
    }
    // override the toString method to return: "Student: " + name + " at " + school
    @Override
    public String toString()
    {
        return "Student:" + name + "at" + school; // your code here
    }
    
    
}
