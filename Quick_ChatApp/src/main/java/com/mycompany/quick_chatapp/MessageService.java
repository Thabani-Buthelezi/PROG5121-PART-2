/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quick_chatapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Thabani Buthelezi
 */
class MessageService {
    private final List<String> sentMessages = new ArrayList<>();
    private int totalMessages = 0;

    public void sendMessages() {
        String numStr = JOptionPane.showInputDialog("Enter the number of messages you wish to send:");
        if (numStr == null) return;

        int count;
        try {
            count = Integer.parseInt(numStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid number entered.");
            return;
        }

        Random rand = new Random();
        for (int i = 1; i <= count; i++) {
            String recipient = JOptionPane.showInputDialog("Enter recipient for message " + i + ":");
            String message = JOptionPane.showInputDialog("Enter your message:");

            long uniqueID = 100000000000000L + (long) (rand.nextDouble() * 900000000000000L);
            String hashID = i + ":" + String.valueOf(uniqueID).substring(12) + ":" + message;

            String messageInfo = """
                    Message Sent Successfully!
                    Message ID: %d
                    Message Hash: %s
                    Recipient: %s
                    Message: %s
                    """.formatted(i, hashID, recipient, message);

            JOptionPane.showMessageDialog(null, messageInfo);
            sentMessages.add(messageInfo);
            totalMessages++;
        }

        JOptionPane.showMessageDialog(null, "All messages sent! Total messages: " + totalMessages);
    }

    public void showMessages() {
        if (sentMessages.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No messages have been sent yet.");
            return;
        }

        StringBuilder sb = new StringBuilder("Recently Sent Messages:\n\n");
        for (String msg : sentMessages) {
            sb.append(msg).append("\n-------------------\n");
        }

        JOptionPane.showMessageDialog(null, sb.toString());
    }
    
}
