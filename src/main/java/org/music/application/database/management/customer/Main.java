package org.music.application.database.management.customer;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
//        Customer customer = new Customer(10, "Eduardo", "Martins",
//                "Woodstock Discos", "Rua Dr. Falcão Filho, 155", "São Paulo",
//                "SP", "Brazil", "01007-010", "+55 (11) 3033-5446",
//                "+55 (11) 3033-4564", "eduardo@woodstock.com.br", 4);
//
//        System.out.println(customer);
//        try (Connection conn = Database.getConnection()) {
//            System.out.println("Database connection successful!");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        CustomerDAO customerDAO = new CustomerDAOImplementation();
        Customer customer = customerDAO.get(5);
        System.out.println(customer);
    }
}
