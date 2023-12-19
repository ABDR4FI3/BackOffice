package com.example.backoffice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {
    String url ;
    String user  ;
    String password ;
    Connection connection ;
    public DbConnection (){
        // JDBC URL, username, and password of MySQL server
        url = "jdbc:mysql://localhost:3306/hoteldb";
        user = "root";
        password = "";

        try {
            // Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            connection = DriverManager.getConnection(url, user, password);

            // Testing Query
            String selectQuery = "SELECT * FROM test";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectQuery);

            // Process the result set
            while (resultSet.next()) {
                // Access data from the result set
                String column1Value = resultSet.getString("id");
                String column2Value = resultSet.getString("name");

                // Process the data as needed
                System.out.println("id: " + column1Value + ", Name: " + column2Value);
            }

            // Close resources
            resultSet.close();
            statement.close();
            //connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public Connection getConnection() {
        return connection;
    }
}

//Test Connection => Done Successfully
/*
class Main{
    public static void main(String[] args) {
        DbConnection MyConnection = new DbConnection();
    }
}
*/
