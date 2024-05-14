package org.music.application.database.management.customer;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class CustomerDAOImplementationTest {

    private Connection conn;
    private CustomerDAOImplementation customerImpDao;

    @BeforeEach
    void setUp() throws SQLException {
        conn = Database.getConnection();
        customerImpDao = new CustomerDAOImplementation();
    }

    @Test
    void shouldReturnACustomerForAGivenCustomerId() throws SQLException {
        Customer expectedCustomer = new Customer(14, "Mark", "Philips", "Telus",
                "8210 111 ST NW", "Edmonton", "AB", "Canada", "T6G 2C7",
                "+1 (780) 434-4554", "+1 (780) 434-5565", "mphilips12@shaw.ca", 5);
        Customer actualCustomer = customerImpDao.get(14);
//        assertEquals(expectedCustomer.getCustomerId(), actualCustomer.getCustomerId());
//        assertTrue(expectedCustomer.getFirstName().equals(actualCustomer.getFirstName()));
//        assertTrue(expectedCustomer.getLastName().equals(actualCustomer.getLastName()));
//        assertTrue(expectedCustomer.getCompany().equals(actualCustomer.getCompany()));
//        assertTrue(expectedCustomer.getAddress().equals(actualCustomer.getAddress()));
//        assertTrue(expectedCustomer.getCity().equals(actualCustomer.getCity()));
//        assertTrue(expectedCustomer.getState().equals(actualCustomer.getState()));
//        assertTrue(expectedCustomer.getCountry().equals(actualCustomer.getCountry()));
//        assertTrue(expectedCustomer.getPostalCode().equals(actualCustomer.getPostalCode()));
//        assertTrue(expectedCustomer.getPhone().equals(actualCustomer.getPhone()));
//        assertTrue(expectedCustomer.getFax().equals(actualCustomer.getFax()));
//        assertTrue(expectedCustomer.getEmail().equals(actualCustomer.getEmail()));
//        assertEquals(expectedCustomer.getSupportRepId(), actualCustomer.getSupportRepId());
        assertTrue(expectedCustomer.equals(actualCustomer));
    }

}