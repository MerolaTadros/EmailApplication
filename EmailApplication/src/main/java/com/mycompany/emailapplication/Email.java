/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.emailapplication;

import java.util.Scanner;

/**
 *
 * @author Merola_Tadros
 */
public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxcapacity;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 8;
    private String alternateEmail;
    private String companySuffix = "aeycompany.com";
    
    //constructor to receive the firstname and lastname
    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        //System.out.println("EMAIL CREATED: " + this.firstName + " " + this.lastName);
        
        //call a mehtod asking for the department
        this.department = setDepartment();
       // System.out.println("Department: " + this.department);
       
        //call a method that returns a random password
        this.password = randomPassword (defaultPasswordLength);
        System.out.println("Your password is: " + this.password);
        
        //combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + this.department + "." + companySuffix;
        //System.out.println("Your email is: " + email);
    }
            
    //Ask for the department
    private String setDepartment(){
        System.out.print("DEPARTMENT CODES\n1 for Sales\n2 for development\n3 for Accounting\n0 for none\nEnter department code");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1){ return "Sales"; }
        else if(depChoice == 2) { return "Dev"; }
        else if(depChoice == 3) { return "Accounting"; }
        else  return ""; 
    }


    //Generate a random password
    private String randomPassword(int length){
    String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
    char[] password = new char[length];
    for(int i=0; i<length; i++){
        int rand = (int)(Math.random()* passwordSet.length());
        password[i] = passwordSet.charAt(rand);
    }
    return new String(password);
}     

    // Set the mailbox capacity 
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }
    //Set the alternate email
    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }
    //Change the password 
     public void changePassword(String password){
         this.password = password;
     }
    
    //getter
     public int getMailboxCapacity() { return mailboxCapacity; }
     public String getAlternateEmail() { return alternateEmail; }
     public String getPassword(){ return password ; }

     public String showInfo(){
         return"DISPLAY NAME: " + firstName + " " + lastName +
                 " COMPANY EMAIL: " + email + 
                 " MAILBOX CAPACITY: " + mailboxCapacity + "mb"; 
     }
             
}