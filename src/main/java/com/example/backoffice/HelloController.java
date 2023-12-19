package com.example.backoffice;

import java.sql.*;

import com.example.backoffice.DbConnection;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
public class HelloController {
    @FXML
    private TextField EmailInput;

    @FXML
    private PasswordField passwordInput;

    private AuthenticationHandler authenticationHandler;

    public HelloController() {
        authenticationHandler = new AuthenticationHandler();
    }

    @FXML
    private void handleLogin() {
        String email = EmailInput.getText();
        String password = passwordInput.getText();

        // Now you can use the email and password values for authentication
        boolean isAuthenticated = authenticationHandler.authenticate(email, password);

        if (isAuthenticated) {
            System.out.println("Authentication successful. Redirecting to the next page.");
            // Add code to redirect to the next page or perform other actions
        } else {
            System.out.println("Authentication failed. Please check your credentials.");
        }
    }
}

class AuthenticationHandler {

    private DbConnection dbConnection;

    public AuthenticationHandler() {
        // Initialize the database connection
        dbConnection = new DbConnection();
    }

    public boolean authenticate(String email, String password) {
        // Implement your authentication logic here
        // Check if the provided email and password exist in the database

        try {
            String selectQuery = "SELECT * FROM admin WHERE AdminName = ? AND Password = ?";
            try (PreparedStatement preparedStatement = dbConnection.getConnection().prepareStatement(selectQuery)) {
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, password);

                ResultSet resultSet = preparedStatement.executeQuery();

                // If a record is found, authentication is successful
                return resultSet.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Authentication failed
        return false;
    }
}