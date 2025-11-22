/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package quick_chat_app3;

import java.awt.HeadlessException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Thabani Buthelezi
 */
public class Quick_Chat_App3 {
    public static void main(String[] args) {

        // Setup file path for saving messages
        MessageService service = new MessageService();
        service.setFilePath("messages.txt");

        JOptionPane.showMessageDialog(null, "Welcome to QuickChat!");
        UserRegistration user = new UserRegistration();

        String firstName = JOptionPane.showInputDialog("Enter your first name:");
        String lastName = JOptionPane.showInputDialog("Enter your last name:");
        String username = JOptionPane.showInputDialog("Enter username (email):");
        String password = JOptionPane.showInputDialog("Enter password:");
        String cellphone = JOptionPane.showInputDialog("Enter South African cellphone number:");

        String regMessage = user.register(firstName, lastName, username, password, cellphone);
        JOptionPane.showMessageDialog(null, regMessage);

        UserLogin login = new UserLogin(username, password);

        if (!login.authenticate()) {
            JOptionPane.showMessageDialog(null, "Exiting... Login failed.");
            return;
        }

        boolean running = true;

        while (running) {

            String menu = """
                    ===== QUICKCHAT MENU =====

                    1) Send a Message
                    2) Display All Senders & Recipients
                    3) Display Longest Message
                    4) Search for Message by ID
                    5) Search Messages by Recipient
                    6) Delete Message by Hash
                    7) Display Full Report
                    8) Quit
                    
                    Enter your choice:
                    """;

            String option = JOptionPane.showInputDialog(menu);
            if (option == null) break;

            switch (option) {

                case "1":
                    sendMessageOption(service);
                    break;

                case "2":
                    JOptionPane.showMessageDialog(null, service.showSendersAndRecipients());
                    break;

                case "3":
                    Message longest = service.getLongestMessage();
                    if (longest == null) {
                        JOptionPane.showMessageDialog(null, "No messages available.");
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Longest Message:\n\n" +
                                        longest.messageText +
                                        "\n\nSender: " + longest.sender +
                                        "\nRecipient: " + longest.recipient);
                    }
                    break;

                case "4":
                    searchMessageByIDOption(service);
                    break;

                case "5":
                    searchByRecipientOption(service);
                    break;

                case "6":
                    deleteMessageByHashOption(service);
                    break;

                case "7":
                    JOptionPane.showMessageDialog(null, service.showFullReport());
                    break;

                case "8":
                    running = false;
                    JOptionPane.showMessageDialog(null, "Goodbye!");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Invalid option. Try again.");
            }
        }
    }

  // SEND MESSAGE OPTION
public static void sendMessageOption(MessageService service) {
    try {
        // Correct way to generate the NEXT message ID
        int id = service.getTotalMessages() + 1;

        String sender = JOptionPane.showInputDialog("Enter sender:");
        if (sender == null) return;

        String recipient = JOptionPane.showInputDialog("Enter recipient:");
        if (recipient == null) return;

        String text = JOptionPane.showInputDialog("Enter message text:");
        if (text == null) return;

        // Generate unique hash
        String hash = "H" + id + System.currentTimeMillis();

        // Create a message
        Message msg = new Message();
        msg.setMessageDetails(id, sender, recipient, text, hash);

        // Store message in service
        service.addMessage(msg);

        // Confirm success
        JOptionPane.showMessageDialog(null,
                "Message sent successfully!\n\n"
                + "Message ID: " + id + "\n"
                + "Sender: " + sender + "\n"
                + "Recipient: " + recipient + "\n"
                + "Message: " + text + "\n"
                + "Hash: " + hash
        );

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null,
                "Error sending message.\n" + e.getMessage());
    }
}

    // SEARCH BY ID OPTION
    public static void searchMessageByIDOption(MessageService service) {
        String input = JOptionPane.showInputDialog("Enter Message ID:");
        if (input == null) return;

        int id = Integer.parseInt(input);

        Message found = service.searchByID(id);

        if (found == null) {
            JOptionPane.showMessageDialog(null, "Message not found.");
        } else {
            JOptionPane.showMessageDialog(null,
                    "Message Found:\n" +
                            "Sender: " + found.sender +
                            "\nRecipient: " + found.recipient +
                            "\nMessage: " + found.messageText);
        }
    }

    // SEARCH BY RECIPIENT OPTION
    public static void searchByRecipientOption(MessageService service) {
        String recipient = JOptionPane.showInputDialog("Enter recipient name:");
        if (recipient == null) return;

        ArrayList<Message> results = service.searchByRecipient(recipient);

        if (results.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No messages found for this recipient.");
        } else {
            StringBuilder sb = new StringBuilder("Messages sent to " + recipient + ":\n\n");

            for (Message msg : results) {
                sb.append("ID: ").append(msg.messageID)
                        .append(" | From: ").append(msg.sender)
                        .append(" | Message: ").append(msg.messageText)
                        .append("\n");
            }

            JOptionPane.showMessageDialog(null, sb.toString());
        }
    }

    // DELETE BY HASH OPTION
    public static void deleteMessageByHashOption(MessageService service) {
        String hash = JOptionPane.showInputDialog("Enter message hash to delete:");
        if (hash == null) return;

        boolean deleted = service.deleteMessageByHash(hash);

        JOptionPane.showMessageDialog(null,
                deleted ? "Message deleted successfully." : "Message not found.");
    }
     }