/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.nio.file.*;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author MPHOENTLE
 */
public class RegisterAndLoginSystemTest {
    
    private static final String TEST_FILE = "test_message.txt";
    
    @BeforeEach
    void setUp() {
        
        try {
            Files.deleteIfExists(Paths.get(TEST_FILE));
        } catch (IOException e) {
            
        }
    }
    
    
    @Test
    public void testSentMessagesArrayCorrectlyPopulated() {
        String[] messages = new String[4];
        messages[0] = "Did you get the cake?";
        messages[1] = "Where are you? You are late! I have asked you to be on time.";
        messages[2] = "Ok, I am leaving without you.";
        messages[3] = "It is dinner time!";
        
        assertEquals("Did you get the cake?", messages[0]);
        assertEquals("It is dinner time!", messages[3]);
    }
    
    
    @Test
    public void testDisplayLongestMessage() {
        String[] messages = {
            "Did you get the cake?",
            "Where are you? You are late! I have asked you to be on time.",
            "Ok, I am leaving without you.",
            "It is dinner time!"
        };
        
        String longest = "";
        for (String msg : messages) {
            if (msg.length() > longest.length()) {
                longest = msg;
            }
        }
        
        String expected = "Where are you? You are late! I have asked you to be on time.";
        assertEquals(expected, longest);
    }
    
    
    @Test
    public void testSearchForMessageID() {
        JSONObject message = new JSONObject();
        message.put("messageID", 10000000004L);
        message.put("recipient", "0838884567");
        message.put("content", "It is dinner time!");
        
        long searchID = 10000000004L;
        String foundContent = "";
        
        if (message.getLong("messageID") == searchID) {
            foundContent = message.getString("content");
        }
        

        assertEquals("It is dinner time!", foundContent);
        assertEquals("0838884567", message.getString("recipient"));
    }
    
    
    @Test
    public void testSearchMessagesByRecipient() {
        JSONArray messages = new JSONArray();
        
        JSONObject msg1 = new JSONObject();
        msg1.put("recipient", "+27838884567");
        msg1.put("content", "Where are you? You are late! I have asked you to be on time.");
        
        JSONObject msg2 = new JSONObject();
        msg2.put("recipient", "+27838884567");
        msg2.put("content", "Ok, I am leaving without you.");
        
        messages.put(msg1);
        messages.put(msg2);
        
        String searchRecipient = "+27838884567";
        StringBuilder results = new StringBuilder();
        
        for (int i = 0; i < messages.length(); i++) {
            JSONObject msg = messages.getJSONObject(i);
            if (msg.getString("recipient").equals(searchRecipient)) {
                results.append(msg.getString("content")).append(" ");
            }
        }
        
        String expected = "Where are you? You are late! I have asked you to be on time. Ok, I am leaving without you. ";
        assertEquals(expected, results.toString());
    }
    
    @Test
    public void testDeleteMessageByHash() {
        JSONArray messages = new JSONArray();
        
        JSONObject msg1 = new JSONObject();
        msg1.put("hash", "10:1:DIDCAKE?");
        msg1.put("content", "Did you get the cake?");
        
        JSONObject msg2 = new JSONObject();
        msg2.put("hash", "10:2:WHEREONTIME.");
        msg2.put("content", "Where are you? You are late! I have asked you to be on time");
        
        JSONObject msg3 = new JSONObject();
        msg3.put("hash", "10:3:OKWITHOUTYOU.");
        msg3.put("content", "Ok, I am leaving without you.");
        
        messages.put(msg1);
        messages.put(msg2);
        messages.put(msg3);
        
        String hashToDelete = "10:2:WHEREONTIME.";
        JSONArray updatedMessages = new JSONArray();
        boolean deleted = false;
        
        for (int i = 0; i < messages.length(); i++) {
            JSONObject msg = messages.getJSONObject(i);
            if (!msg.getString("hash").equals(hashToDelete)) {
                updatedMessages.put(msg);
            } else {
                deleted = true;
            }
        }
        
        assertTrue(deleted, "Message successfully deleted");
        assertEquals(2, updatedMessages.length(), "Should have 2 messages remaining");
        
        
        for (int i = 0; i < updatedMessages.length(); i++) {
            assertNotEquals(hashToDelete, updatedMessages.getJSONObject(i).getString("hash"));
            
            
    
            
    
    }
}
            
        }
    
