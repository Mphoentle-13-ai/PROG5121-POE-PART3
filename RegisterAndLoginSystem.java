package com.mycompany.registerandloginsystem;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.Scanner;

public class RegisterAndLoginSystem {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Part 3 declarations
        int storageOption;
        String firstName = null;

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
                    firstName = input.nextLine();

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
                            // Adding menu option for Part 3
                            System.out.println("4. Store Messages");

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
                                            break;
                                        }

                                        // Auto generating the messageID
                                        long messageID = 10000000000L + (long) (Math.random() * 90000000000L);

                                        // Auto generating the messageHash
                                        // Generating the first and last word of the sentence
                                        String[] words = message.trim().split("\\s+");
                                        String firstWord = words[0].toUpperCase();
                                        String lastWord = words[words.length - 1].toUpperCase();

                                        // Generating the first two numbers of the messageID
                                        String firstTwo = String.valueOf(messageID).substring(0, 2);
                                        
                                        String messageHash = firstTwo + ":" + messageCount + ":" + firstWord + lastWord;

                                        // Message information
                                        System.out.println("Message ID: " + messageID);
                                        System.out.println("Message hash: " + messageHash);
                                        System.out.println("Recipient: " + recipient);
                                        // FIX: print the actual message string, not the array reference
                                        System.out.println("Message: " + messages[messageCount - 1]);

                                        System.out.println("\n-Message systems:-");
                                        System.out.println("1. Send message");
                                        System.out.println("2. Disregard message (to delete a message)");
                                        System.out.println("3. Store message to send later");

                                        System.out.print("Select an option: ");
                                        int messageOption = input.nextInt();
                                        input.nextLine();

                                        if (messageOption == 1) {
                                            System.out.println("Message successfully sent");

                                        } else if (messageOption == 2) {
                                            
                                            System.out.print("Press 0 to delete the message: ");
                                            int pressed = input.nextInt();
                                            input.nextLine();
                                            if (pressed == 0) {
                                                System.out.println("Message successfully deleted");
                                                // Remove the last message
                                                messages[messageCount - 1] = null;
                                                messageCount--;
                                            } else {
                                                System.out.println("Message not successfully deleted");
                                            }

                                        } else if (messageOption == 3) {
                                            
                                            JSONArray messageArray = new JSONArray();

                                            // Read existing messages if file already exists
                                            try {
                                                String existingContent = new String(Files.readAllBytes(Paths.get("message.txt")));
                                                messageArray = new JSONArray(existingContent);
                                            } catch (IOException e) {
                                                // If file doesn't exist, use empty array created above
                                            }

                                            // Create JSON object for the new message
                                            JSONObject messageObj = new JSONObject();
                                            messageObj.put("MessageID", messageID);
                                            messageObj.put("Message Hash", messageHash);
                                            messageObj.put("Recipient", recipient);
                                            messageObj.put("Content", message);
                                            messageObj.put("messageNumber", messageCount);

                                            // Add to array
                                            messageArray.put(messageObj);

                                            // Save to file
                                            try (FileWriter file = new FileWriter("message.txt")) {
                                                file.write(messageArray.toString(4));
                                                System.out.println("Message saved to text file.");
                                            } catch (IOException e) {
                                                System.out.println("ERROR: " + e.getMessage());
                                            }
                                        }

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

                case 4:
                    // Part 3 - Stored Messages menu
                    System.out.println("--Stored Messages menu option--");
                    System.out.println("1. Display sender and recipient of all stored messages.");
                    System.out.println("2. Display the longest stored message.");
                    System.out.println("3. Search for a message ID and display corresponding recipient and message.");
                    System.out.println("4. Search for all messages stored for a particular recipient.");
                    System.out.println("5. Delete a message using the message hash.");
                    System.out.println("6. Display a report that lists full details of all stored messages.");

                    System.out.print("Choose option: ");
                    storageOption = input.nextInt();
                    input.nextLine();

                    
                    switch (storageOption) {
                        case 1:
                            System.out.println("Sender: " + firstName);
                            break;
                        case 2:
                            System.out.println("Longest message: ");
                            break;
                        case 3:
                            System.out.print("Enter message ID: ");
                            String searchID = input.nextLine();
                            System.out.println("Searching for message ID: " + searchID);
                            break;
                        case 4:
                            System.out.print("Enter recipient cellphone number: ");
                            String searchRecipient = input.nextLine();
                            System.out.println("Searching messages for: " + searchRecipient);
                            break;
                        case 5:
                            System.out.print("Enter message hash: ");
                            String searchHash = input.nextLine();
                            System.out.println("Deleting message with hash: " + searchHash);
                            break;
                        case 6:
                            System.out.println("\n--FULL DETAILED REPORT--");
                            System.out.println("Recipient: ");
                            System.out.println("Message: ");
                            System.out.println("Message ID: ");
                            System.out.println("Message hash: ");
                            break;
                        default:
                            System.out.println("Please enter a number 1 to 6!");
                            break;
                    }

                    break; 

                default:

                    System.out.println("Invalid option. Please try again.");
            }
        }

        input.close();
    }
}