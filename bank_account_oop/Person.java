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
public class Person {
    protected int id;
    protected String name;
    protected String address;
    
    public Person(int id, String name)
    {
        this.id = id;   //your code here
        this.name = name;
        
       
    }
    public void setAddress(String address)
    {
        this.address = address; //your code here
    }
    public String getAddress()
    {
        return address;//your code here
    }
    
    public int getId()
    {
        return id;//your code here
    }
    public String getName()
    {
       return name;//your code here
    }
    // override the toString method to return: "Person: " + name
    // your code here
    @Override
    public String toString()
    {
        return "Person:" + name;
    }
    
    // override the equals method to return true if the ID and name are equal
    public boolean equals(Person other)
    {
        if(other instanceof Person) //your code here
        {
            if(other.name.equals(name) && other.id==id) // here 
                return true;
        } 
              return false;
    }
}
