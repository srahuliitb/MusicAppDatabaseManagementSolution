package org.music.application.database.management.customer;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {
//        try (Connection conn = Database.getConnection()) {
//            System.out.println("Database connection successful!");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        CustomerDAO customerDAO = new CustomerDAOImplementation();
//        Customer customer = customerDAO.get(5);
//        System.out.println(customer);

//        List<Customer> customers = customerDAO.getAll();
//        for (Customer c : customers) {
//            System.out.println(c);
//        }

//        Customer customer = new Customer(60, "Songyun", "Tan",
//                "Newcastle University", "Vita Strawberry", "Newcastle upon Tyne",
//                "Tyne and Wear", "UK", "NE1 4PQ", "+44 020 3096 1717",
//                null, "Tan.Songyun@ncl.co.uk", 4);
//        int result = customerDAO.insert(customer);
//        System.out.println(result);

//        Customer customer = new Customer(60, "Songyun", "Tan",
//                "School of Computing, Newcastle University", "Vita Strawberry", "Newcastle upon Tyne",
//                "Tyne and Wear", "UK", "NE1 4PQ", "+44 020 3096 1717",
//                null, "Tan.Songyun@ncl.co.uk", 4);
//        int result = customerDAO.update(customer);
//        System.out.println(result);

//        Customer customer = customerDAO.get(0);
//        System.out.println(customer);
//
//        int result = customerDAO.delete(customer);
//        System.out.println(result);

//        Customer customer = new Customer(60, "Songyun", "Tan",
//                "Newcastle University", "Vita Strawberry", "Newcastle upon Tyne",
//                "Tyne and Wear", "UK", "NE1 4PQ", "+44 020 3096 1717",
//                null, "Tan.Songyun@ncl.co.uk", 4);
//        int result = customerDAO.save(customer);
//        System.out.println(result);
    }
}
