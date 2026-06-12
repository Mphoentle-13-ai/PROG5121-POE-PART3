package com.mycompany.registerandloginsystem;

import java.util.Scanner;

public class RegisterAndLoginSystem {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Stored login details
        String storedUsername = "MNS_1";
        String storedPassword = "Ch&&sec@ke9!";
        
        String message = null;

        boolean running = true;

        while (running) {

            // Main menu
            System.out.println("\n==== Main Menu ====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            System.out.print("Choose option: ");
            int menuChoice = input.nextInt();
            input.nextLine();

            switch (menuChoice) {

                case 1:

                    // Registration
                    System.out.print("Enter first name: ");
                    String firstName = input.nextLine();

                    System.out.print("Enter last name: ");
                    String lastName = input.nextLine();

                    System.out.print("Create username: ");
                    String username = input.nextLine();

                    System.out.print("Create password: ");
                    String password = input.nextLine();

                    System.out.println("\nRegistration successful!");
                    System.out.println("Welcome " + firstName + " " + lastName
                            + ", it is great to see you.");

                    break;

                case 2:

                    // Login
                    System.out.print("Enter username: ");
                    String loginUsername = input.nextLine();

                    System.out.print("Enter password: ");
                    String loginPassword = input.nextLine();

                    if (loginUsername.equals(storedUsername)
                            && loginPassword.equals(storedPassword)) {

                        System.out.println("\nLogin successful!");
                        System.out.println("Welcome to QuickChat.");

                        // Ask how many messages
                        System.out.print("How many messages would you like to enter?: ");
                        int maxMessages = input.nextInt();
                        input.nextLine();

                        String[] messages = new String[maxMessages];
                        int messageCount = 0;

                        boolean quickChatRunning = true;

                        while (quickChatRunning) {

                            System.out.println("\n==== QuickChat Menu ====");
                            System.out.println("1. Send Messages");
                            System.out.println("2. Show Recently Sent Messages");
                            System.out.println("3. Quit");

                            System.out.print("Choose option: ");
                            int choice = input.nextInt();
                            input.nextLine();

                            switch (choice) {

                                case 1:

                                    // Enter recipient number
                                    System.out.print("Enter recipient cell number: ");
                                    String recipient = input.nextLine();

                                    // Validate number
                                    if (recipient.startsWith("+27")
                                            && recipient.length() == 12) {

                                        System.out.println("Cell number successfully saved.");

                                        // Send message
                                        if (messageCount < maxMessages) {

                                            System.out.print("Enter your message: ");
                                            message = input.nextLine();

                                            messages[messageCount] = message;
                                            messageCount++;

                                            System.out.println("Message sent successfully.");

                                        } else {

                                            System.out.println("You have reached the maximum number of messages.");
                                        }
                                        //Auto generating the messageID
                                        long messageID = 10000000000L + (long) (Math.random() * 90000000000L);
                                        
                                        //Auto generating the messageHash
                                          // Generating the frist and last word of the sentence
                                          String[] words = message.trim().split("\\s+");
                                          String FirstWord = words[0].toUpperCase();
                                          String LastWord = words[words.length - 1].toUpperCase();
                                          
                                          //Generating the first two numbers of the messageID
                                          String firstTwo = String.valueOf(messageID).substring(0, 2);
                                          String maxMessage = null;
                                          String messageHash = firstTwo + ":" + maxMessage + ":" + FirstWord + LastWord;
                                          
                                          //Message information
                                          System.out.println("Message ID: " + messageID);
                                          System.out.println("Message hash: " +messageHash);
                                          System.out.println("Recipient: " + recipient);
                                          System.out.println("Message: " + messages);
                                          
                                    } else {

                                        System.out.println("Invalid cell number.");
                                        System.out.println("Number must start with +27 and be 12 characters long.");
                                    }

                                    break;

                                case 2:

                                    // Show messages
                                    if (messageCount == 0) {

                                        System.out.println("No messages sent yet.");

                                    } else {

                                        System.out.println("\nRecently Sent Messages:");

                                        for (int i = 0; i < messageCount; i++) {

                                            System.out.println((i + 1) + ". " + messages[i]);
                                        }
                                    }

                                    break;

                                case 3:

                                    // Quit QuickChat
                                    System.out.println("Exiting QuickChat...");
                                    quickChatRunning = false;

                                    break;

                                default:

                                    System.out.println("Invalid option. Please try again.");
                            }
                        }

                    } else {

                        System.out.println("Invalid username or password.");
                    }

                    break;

                case 3:

                    // Exit application
                    System.out.println("Exiting application...");
                    running = false;

                    break;

                default:

                    System.out.println("Invalid option. Please try again.");
            }
        }

        input.close();
    }
}