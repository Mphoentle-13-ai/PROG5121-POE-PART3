/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.loginclassfeature;

/**
 *
 * @author MPHOENTLE
 */
import java.util.Scanner;

public class LoginClassFeature {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        
        //USERNAME
        System.out.println("Must contain an underscore");
        System.out.println("Is no more than 5 characters long");
        
        System.out.print("Enter username: ");
        String username = input.nextLine();
        
        boolean validUsername = false;
        
        if (username.length() <=5 && username.contains("_")) {
            System.out.println("Username accepted");
            validUsername = true;
        } else {
            System.out.println("Username too long");
        }
        
        //PASSWORD
        System.out.println("Must be eight characters long");
        System.out.println("Must contain a captial letter");
        System.out.println("Must contain a number");
        System.out.println("Must contain special characters");
        
        System.out.print("Enter password: ");
        String password = input.nextLine();
        
        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;
        
        for (char c : password.toCharArray()) {
         if (Character.isUpperCase(c)) hasCapital = true;
            if (Character.isDigit(c)) hasNumber = true;
            if (!Character.isLetterOrDigit(c)) hasSpecial = true; 
            
        }
        
        if (password.length() >=8 && hasCapital && hasNumber && hasSpecial) {
            System.out.println("Password accepted");
        } else if (password.length() >8) {
            System.out.println("Password too long");
        } else {
            System.out.println("Password too short");
        }
        
        //CELLPHONE
        System.out.println("Contains international country code");
        System.out.println("Contains 10 digits (e.g +27123456789)");
        
        System.out.print("Enter cellphone number: ");
        String cellphone = input.nextLine();
        
        if (cellphone.startsWith("+27") && cellphone.length() == 12) {
            System.out.println("Invalid cellphone number");
        } else {
            System.out.println("Cellphopne number accepted");
        }
        
        //RESULTS
        System.out.println("\n---RESULT---");
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println("Cellphone: " + cellphone);     
        
        input.close();
    }
}
