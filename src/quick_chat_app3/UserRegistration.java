/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quick_chat_app3;

/**
 *
 * @author Thabani Buthelezi
 */
public class UserRegistration {
    public String register(String firstName, String lastName, String username, String password, String cellphone) {

        if (firstName.isBlank() || lastName.isBlank() || username.isBlank() || password.isBlank() || cellphone.isBlank()) {
            return "Registration failed: All fields are required.";
        }

        if (!username.contains("@") || !username.contains(".")) {
            return "Invalid email format.";
        }

        if (password.length() < 8) {
            return "Password must be at least 8 characters.";
        }

        if (!cellphone.matches("^0[6-8][0-9]{8}$")) {
            return "Invalid South African phone number.";
        }

        return "Registration successful! Welcome " + firstName + " " + lastName + "!";
    }

    boolean registerUser(String thabani, String buthelezi, String thabani123, String password1, String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
    