/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quick_chat_app3;

import javax.swing.JOptionPane;

/**
 *
 * @author Thabani Buthelezi
 */
class UserLogin {
     public String registeredUsername;
    public String registeredPassword;

    public UserLogin(String username, String password) {
        this.registeredUsername = username;
        this.registeredPassword = password;
    }

    public boolean authenticate() {
        String loginUsername = JOptionPane.showInputDialog("Enter your username:");
        String loginPassword = JOptionPane.showInputDialog("Enter your password:");

        if (loginUsername == null || loginPassword == null) {
            return false;
        }

        if (loginUsername.equals(registeredUsername) && loginPassword.equals(registeredPassword)) {
            JOptionPane.showMessageDialog(null, "Login successful!");
            return true;
        }

        JOptionPane.showMessageDialog(null, "Incorrect username or password.");
        return false;
    }
}