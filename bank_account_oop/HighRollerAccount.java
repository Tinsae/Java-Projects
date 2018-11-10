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
public class HighRollerAccount extends BasicAccount{
    // A high roller account has all the behaviors and properties of a basic account,
    // but a zero maintenance fee is collected from a high roller account
    // and when interest is added, it is added twice:
    // e.g balance 100, intRate = 0.1 => 110 (from first interest added) => 121 (from second interest added)
    public HighRollerAccount(int id, Person owner, String bank, double balance)
    {
        super(id,owner,bank); //your code here
        super.maintFee = 0.0;
         
    }
    @Override
    public void addInterest()
    {
        balance = balance + (intRate*100); //your code here
        balance = balance + (intRate*100);
    }
    @Override
    public String toString()
    {
        return "High Roller:" + super.toString();
    }
    //override the toString method to return: "High Roller " + whatever the basic account returns
    //your code here
}
