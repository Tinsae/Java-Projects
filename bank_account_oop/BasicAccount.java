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
public class BasicAccount {
    protected int acctId;
    protected Person owner;
    protected String bank;
    protected double balance; // never negative
    protected double intRate; // the interest rate, e.g. 0.02  (for 2 %)
    protected double maintFee;
    
    public BasicAccount(int acctId, Person owner, String bank)
    {
         this.acctId = acctId;//your code here
         this.owner = owner;
         this.bank = bank;
         balance = 0;
         
    }
    //Deposit the given amount if positive. Negative amounts are ignored.
    //@param amount The amount to deposit
    //@return The balance after deposit was accepted
    
    public double deposit(double amount)
    {
        if(amount > 0)
        {
            balance = balance + amount;
        }
        return balance;
         //your code here
    }
    
    //Withdraw the given amount if positive and if there are enough funds.
    //Negative amounts are ignored. If the amount to be withdrawn is higher than the balance,
    //withdraw the entire balance.
    //@param amount The amount to withdraw
    //@return The amount withdrawn
    
    public double withdraw(double amount)
    {
        if (amount > 0)
        {
            if(amount > balance)
            {
                double temp = balance ;
                balance = 0;
                return temp;
                
            }
            else
            {
                balance = balance - amount;
                return amount;
            }
        }
        else
        {
            return -1;
        }
         //your code here
    }
    public double getBalance()
    {
        return balance; //your code here
    }
    public int getAcctId()
    {
         return acctId;//your code here
    }
    public Person getOwner()
    {
         return owner;//your code here
    }
    public void setInterestRate(double intRate)
    {
         this.intRate = intRate;//your code here
    }
    public void setMaintFee(double maintFee)
    {
         this.maintFee = maintFee;//your code here
    }
    //Add the accrued interest to the account. 
    //If balance is 100 and intRate is 0.02, balance should become 102.
    public void addInterest()
    {
         balance = balance + (intRate * 100);//your code here
    }
    //Withdraw the account maintenance fee
    //return The fee collected
    public double assessMaintenanceFee()
    {
         balance = balance - maintFee;//your code here
         return maintFee;
    }
    //override the toString method to return:
    // "Account of " + owner + " with ID " + acctId + " and a balance of " + balance
    @Override
    public String toString()
    {
        return "Account of" + owner + "with ID" + acctId + "and a balance of" + balance;  //your code here
    }
   
    
    //override the equals method to return true if the acctId and bank name are equal
    public boolean equals(BasicAccount other)
    {
        if(other instanceof BasicAccount)
        {
            if(other.bank.equals(bank) && other.acctId == acctId)
            {
                return true;
            }
        }
        return false;
    }
    
}
