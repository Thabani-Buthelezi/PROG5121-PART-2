/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quick_chat_app3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 *
 * @author Thabani Buthelezi
 */
class MessageService {
    public ArrayList<Message> messages = new ArrayList<>();
    public String filePath;
    public int totalMessages = 0;

    // NO CONSTRUCTOR – we use a parameter instead
    public void setFilePath(String path) {
        this.filePath = path;
        loadMessagesFromFile();
    }

    // =======================================
    // 1. SAVE ALL MESSAGES TO TEXT FILE
    // =======================================
    public void saveMessagesToFile() {
        try {
            FileWriter writer = new FileWriter(filePath);

            for (Message msg : messages) {
                writer.write(msg.messageID + "," +
                        msg.sender + "," +
                        msg.recipient + "," +
                        msg.messageText + "," +
                        msg.messageHash + "\n");
            }

            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // =======================================
    // 2. LOAD MESSAGES FROM FILE
    // =======================================
    public void loadMessagesFromFile() {
        messages.clear();
        totalMessages = 0;

        try {
            File file = new File(filePath);
            if (!file.exists()) {
                return; // nothing to load
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length == 5) {
                    int id = Integer.parseInt(parts[0]);
                    String sender = parts[1];
                    String recipient = parts[2];
                    String text = parts[3];
                    String hash = parts[4];

                    Message msg = new Message(id, sender, recipient, text, hash);
                    messages.add(msg);
                    totalMessages++;
                }
            }

            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // =======================================
    // 3. ADD MESSAGE
    // =======================================
    public void addMessage(Message message) {
        messages.add(message);
        totalMessages++;
        saveMessagesToFile();
    }

    // =======================================
    // 4. DISPLAY ALL SENDERS AND RECIPIENTS
    // =======================================
    public String showSendersAndRecipients() {
        StringBuilder sb = new StringBuilder();

        for (Message msg : messages) {
            sb.append("Sender: ").append(msg.sender)
                    .append(" -> Recipient: ").append(msg.recipient)
                    .append("\n");
        }

        return sb.toString();
    }

    // =======================================
    // 5. FIND LONGEST MESSAGE
    // =======================================
    public Message getLongestMessage() {
        if (messages.isEmpty()) return null;

        Message longest = messages.get(0);

        for (Message msg : messages) {
            if (msg.messageText.length() > longest.messageText.length()) {
                longest = msg;
            }
        }
        return longest;
    }

    // =======================================
    // 6. SEARCH MESSAGE BY ID
    // =======================================
    public Message searchByID(int id) {
        for (Message msg : messages) {
            if (id == msg.messageID()) {
                return msg;
            } else {
            }
        }
        return null;
    }

    // =======================================
    // 7. SEARCH MESSAGES BY RECIPIENT
    // =======================================
    public ArrayList<Message> searchByRecipient(String recipient) {
        ArrayList<Message> results = new ArrayList<>();

        for (Message msg : messages) {
            if (msg.recipient.equalsIgnoreCase(recipient)) {
                results.add(msg);
            }
        }

        return results;
    }

    // =======================================
    // 8. DELETE MESSAGE BY HASH
    // =======================================
    public boolean deleteMessageByHash(String hash) {
        for (Message msg : messages) {
            if (msg.messageHash.equals(hash)) {
                messages.remove(msg);
                totalMessages--;
                saveMessagesToFile();
                return true;
            }
        }
        return false;
    }

    // =======================================
    // 9. FULL REPORT
    // =======================================
    public String showFullReport() {
        StringBuilder sb = new StringBuilder();

        sb.append("===== FULL MESSAGE REPORT =====\n\n");
        for (Message msg : messages) {
            sb.append("Message ID: ").append(msg.messageID).append("\n");
            sb.append("Sender: ").append(msg.sender).append("\n");
            sb.append("Recipient: ").append(msg.recipient).append("\n");
            sb.append("Message: ").append(msg.messageText).append("\n");
            sb.append("Hash: ").append(msg.messageHash).append("\n");
            sb.append("------------------------------\n");
        }

        return sb.toString();
    }

    // =======================================
    // 10. GET TOTAL
    // =======================================
    public int getTotalMessages() {
        return totalMessages;
    }
}