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
public class StudentAccount extends BasicAccount{
   // A student account has all the behaviors and properties of a basic account,
   // but a zero maintenance fee is collected from a student account
    public StudentAccount(int id, Student owner, String bank)
    {
        super(id,owner,bank);
        super.maintFee = 0.0;    // your code here
    }
    // your code here
    
}
