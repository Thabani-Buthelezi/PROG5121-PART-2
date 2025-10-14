/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.quick_chatapp;

import javax.swing.JOptionPane;

/**
 *
 * @author Thabani Buthelezi
 */
public class Quick_ChatApp {

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Welcome to QuickChat!");

        // Registration phase
        UserRegistration user = new UserRegistration();

        String firstName = JOptionPane.showInputDialog("Enter your first name:");
        String lastName = JOptionPane.showInputDialog("Enter your last name:");
        String username = JOptionPane.showInputDialog("Enter username (email):");
        String password = JOptionPane.showInputDialog("Enter password:");
        String cellphone = JOptionPane.showInputDialog("Enter South African cellphone number:");

        String regMessage = user.register(firstName, lastName, username, password, cellphone);
        JOptionPane.showMessageDialog(null, regMessage);

        // Login phase
        UserLogin login = new UserLogin(username, password);
        if (!login.authenticate()) {
            JOptionPane.showMessageDialog(null, "Exiting... Login failed.");
            return;
        }

        // Message handling
        MessageService messageService = new MessageService();
        boolean running = true;

        while (running) {
            String menu = """
                    Please choose an option:
                    1) Send Messages
                    2) Show Recently Sent Messages
                    3) Quit
                    """;

            String option = JOptionPane.showInputDialog(menu);
            if (option == null) break;

            switch (option) {
                case "1" -> messageService.sendMessages();
                case "2" -> messageService.showMessages();
                case "3" -> {
                    JOptionPane.showMessageDialog(null, "Exiting QuickChat... Goodbye!");
                    running = false;
                }
                default -> JOptionPane.showMessageDialog(null, "Invalid option. Please try again.");
            }
        }
    }
    
}
