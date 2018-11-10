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
public class Main{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
       Bank b = new Bank("Bank of Rupt");
       
       b.setIntRate(0.1);
       b.setMaintFee(50);
       
       Person bob = new Person(11315, "Bob");
       int bobAcctId = b.openAccount(bob,1000);
       
       Person alice = new Student(12512, "Alice","SMC",1234);
       int aliceAcctId = b.openAccount(alice,500);
       
       Person rich = new Person(51542, "Rich P. Person");
       int richAcctId = b.openAccount(rich, 1000000);
       
       Person richStudent = new Student(23814, "Rich S.Student", "USC", 1991);
       int richStudentAccId = b.openAccount(richStudent,100100);
       
       // another account for Rich S. Student
       b.openAccount(richStudent, 30000);
       // another account for Alice
       b.openAccount(alice, 100);
       // another account for Bob
       b.openAccount(bob, 5000);
       
       System.out.println("All the accounts: ");
       b.printAllAccounts();    
       System.out.println();
       
       System.out.println("All the accounts of Alice: ");
       b.printAccountsForOwner(alice);
       System.out.println();
       
       System.out.println("Paying interest : ");
       b.payInterest();
       b.printAllAccounts();
       System.out.println();
       
       System.out.println("Assessing maintenance fees: ");
       b.assessMaintenanceFee();
       b.printAllAccounts();
       System.out.println();
       
       System.out.println("Rich P. Person buys a Ferrari, Alice wins the lottery, Rich. S. Student pays tuition ...");
       b.withdraw(richAcctId, 331000);
       b.printAccountsForOwner(rich);
       b.deposit(aliceAcctId, 100000);
       b.printAccountsForOwner(alice);
       b.withdraw(richStudentAccId, 45000);
       b.printAccountsForOwner(richStudent);
       System.out.println();

    }
    
}
