package org.music.application.database.management.customer;

import java.sql.*;

public class CheckDatabaseConnection {
    public static void main(String[] args) throws SQLException {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/music_app",
                    "root", "$kalashnikov2892");
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Customer");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("FirstName"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
