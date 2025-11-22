/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quick_chat_app3;

/**
 *
 * @author Thabani Buthelezi
 */
class MessageData {
     public int id;
    public String sender;
    public String recipient;
    public String message;
    public String hash;

    public MessageData(int id, String sender, String recipient, String message, String hash) {
        this.id = id;
        this.sender = sender;
        this.recipient = recipient;
        this.message = message;
        this.hash = hash;
    }

    @Override
    public String toString() {
        return "ID: " + id +
               "\nSender: " + sender +
               "\nRecipient: " + recipient +
               "\nMessage: " + message +
               "\nHash: " + hash;
    }
}
