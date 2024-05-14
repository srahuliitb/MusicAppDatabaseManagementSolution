package org.music.application.database.management.customer;

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

//        CustomerDAO customerDAO = new CustomerDAOImplementation();
//        Customer customer = customerDAO.get(5);
//        System.out.println(customer);

//        List<Customer> customers = customerDAO.getAll();
//        for (Customer c : customers) {
//            System.out.println(c);
//        }

        Customer customer1 = new Customer(60, "Songyun", "Tan",
                "Newcastle University", "Vita Strawberry", "Newcastle upon Tyne",
                "Tyne and Wear", "UK", "NE1 4PQ", "+44 020 3096 1717",
                null, "Tan.Songyun@ncl.co.uk", 4);
//        int result = customerDAO.insert(customer1);
//        System.out.println(result);

        Customer customer2 = new Customer(60, "Songyun", "Tan",
                "School of Computing, Newcastle University", "Vita Strawberry", "Newcastle upon Tyne",
                "Tyne and Wear", "UK", "NE1 4PQ", "+44 020 3096 1717",
                null, "Tan.Songyun@ncl.co.uk", 4);
//        int result = customerDAO.update(customer2);
//        System.out.println(result);

        System.out.println(customer1.equals(customer2));

//        Customer customer = customerDAO.get(0);
//        System.out.println(customer);
//
//        int result = customerDAO.delete(customer);
//        System.out.println(result);

//        Customer customer = new Customer(61, "Yang", "Zi",
//                "Newcastle University", "Vita Strawberry", "Newcastle upon Tyne",
//                "Tyne and Wear", "UK", "NE1 4PQ", "+44 020 3096 1717",
//                null, "Zi.Yang@ncl.co.uk", 4);
//        int result = customerDAO.save(customer);
//        System.out.println(result);
    }
}
