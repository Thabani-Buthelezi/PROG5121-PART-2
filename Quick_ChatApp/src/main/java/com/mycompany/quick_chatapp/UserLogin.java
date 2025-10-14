/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quick_chatapp;

import javax.swing.JOptionPane;

/**
 *
 * @author Thabani Buthelezi
 */
class UserLogin {
    private final String registeredUsername;
    private final String registeredPassword;

    public UserLogin(String username, String password) {
        this.registeredUsername = username;
        this.registeredPassword = password;
    }

    public boolean authenticate() {
        String loginUsername = JOptionPane.showInputDialog("Enter your username to login:");
        String loginPassword = JOptionPane.showInputDialog("Enter your password:");

        if (loginUsername == null || loginPassword == null) return false;

        if (loginUsername.equals(registeredUsername) && loginPassword.equals(registeredPassword)) {
            JOptionPane.showMessageDialog(null, "Login successful! Welcome back to QuickChat.");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect username or password.");
            return false;
        }
    }
}
