/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.messagesystem;

/**
 *
 * @author MPHOENTLE
 */
public class MessageSystem {

   // Main method
    public static void main(String[] args) {

        Message message = new Message();

    }

    // Check if message ID is valid
    public boolean checkMessageID(String id) {
        if (idString.length() <= 10) {
            return String.valueOf(id).length() <= 10;
        } else {
            return false;
        }
    }

    // Simulate sending message options
    public String SentMessage(int option) {

        switch (option) {

            case 1:
                return "Message successfully sent.";

            case 2:
                return "Press 0 to delete the message.";

            case 3:
                return "Message successfully stored.";

            default:
                return "Invalid option.";
        }
    }

    // Generate simple message hash
    public String createMessageHash(String messageHash) {

        return Integer.toHexString(messageHash.hashCode()).toUpperCase();
    }

    private boolean sentMessage() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static class idString {

        private static int length() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        public idString() {
        }
    }
}

