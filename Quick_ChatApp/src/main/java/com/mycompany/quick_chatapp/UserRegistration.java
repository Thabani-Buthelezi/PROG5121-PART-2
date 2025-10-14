/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quick_chatapp;

/**
 *
 * @author Thabani Buthelezi
 */
class UserRegistration {
    public String register(String firstName, String lastName, String username, String password, String cellphone) {
        if (firstName.isBlank() || lastName.isBlank() || username.isBlank() || password.isBlank() || cellphone.isBlank()) {
            return "Registration failed: All fields are required.";
        }

        if (!username.contains("@") || !username.contains(".")) {
            return "Invalid email format for username.";
        }

        if (password.length() < 8) {
            return "Password must be at least 8 characters long.";
        }

        if (!cellphone.matches("^0[6-8][0-9]{8}$")) {
            return "Invalid South African cellphone number.";
        }

        return "Registration successful!\nWelcome " + firstName + " " + lastName + "!";
    }
    
}
