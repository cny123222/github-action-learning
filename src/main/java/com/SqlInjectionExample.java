package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlInjectionExample {

    public void doLogin(String user, String pass) {
        // Use try-with-resources and PreparedStatement to avoid SQL injection
        String url = "jdbc:mysql://localhost/test?user=myuser&password=mypass";
        String query = "SELECT * FROM users WHERE user = ? AND password = ?";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, user);
            pstmt.setString(2, pass);

            try (ResultSet rs = pstmt.executeQuery()) {
                // Process result set if needed
            }

        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        }
    }
    
}
