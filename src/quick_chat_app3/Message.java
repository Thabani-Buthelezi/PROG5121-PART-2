/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quick_chat_app3;

/**
 *
 * @author Thabani Buthelezi
 */
class Message {
    private int id;
    String sender;
    String recipient;
    private String message;
    private String hash;
    String messageID;
    String messageText;
    String messageHash;

    Message(int id, String sender, String recipient, String text, String hash) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    Message() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setData(int id, String sender, String recipient, String message, String hash) {
        this.id = id;
        this.sender = sender;
        this.recipient = recipient;
        this.message = message;
        this.hash = hash;
    }

    public int getId() { return id; }
    public String getSender() { return sender; }
    public String getRecipient() { return recipient; }
    public String getMessage() { return message; }
    public String getHash() { return hash; }

    void setMessageDetails(int id, String sender, String recipient, String text, String hash) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    int messageID() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}