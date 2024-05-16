package org.music.application.database.management.customer;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.function.Supplier;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        try (Connection conn = Database.getConnection()) {
//            System.out.println("Database connection successful!\nDatabase Name: " + conn.getCatalog());
            logger.info(String.format("Database connection successful!\nDatabase Name: %s", conn.getCatalog()));

            CustomerDAO customerDAO = new CustomerDAOImplementation();

            Customer customer = customerDAO.get(5);
            logger.info(customer.toString());

            List<Customer> customers = customerDAO.getAll();
            for (Customer c : customers) {
                logger.info(c.toString());
            }

//            Customer customer1 = new Customer(60, "Songyun", "Tan",
//                "Newcastle University", "Vita Strawberry", "Newcastle upon Tyne",
//                "Tyne and Wear", "UK", "NE1 4PQ", "+44 020 3096 1717",
//                null, "Tan.Songyun@ncl.co.uk", 4);
//            System.out.println(customerDAO.insert(customer1));

//            Customer customer2 = new Customer(60, "Songyun", "Tan",
//                null, "Vita Strawberry", "Newcastle upon Tyne",
//                "Tyne and Wear", "UK", "NE1 4PQ", "+44 020 3096 1717",
//                null, "Tan.Songyun@ncl.co.uk", 4);
//            System.out.println(customerDAO.update(customer2));
//            System.out.println(customer1.equals(customer2));

//            System.out.println(customerDAO.delete(customer2));

//            Customer customer3 = new Customer(61, "Yang", "Zi",
//                "Newcastle University", "Vita Strawberry", "Newcastle upon Tyne",
//                "Tyne and Wear", "UK", "NE1 4PQ", "+44 020 3096 1717",
//                null, "Zi.Yang@ncl.co.uk", 4);
//        int result = customerDAO.save(customer);
//        System.out.println(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
