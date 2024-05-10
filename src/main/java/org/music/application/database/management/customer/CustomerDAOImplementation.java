/**
 * Implementation of the CustomerDAO interface for accessing and managing customer data in the database.
 * Provides methods to perform CRUD (Create, Read, Update, Delete) operations specific to customers.
 */
package org.music.application.database.management.customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CustomerDAOImplementation implements CustomerDAO {
    // CRUD - Retrieve
    /**
     * Retrieves a customer from the database based on the provided customer ID.
     *
     * @param id The unique identifier of the customer to retrieve.
     * @return The retrieved customer object.
     * @throws SQLException If an SQL exception occurs while accessing the database.
     */
    @Override
    public Customer get(int id) throws SQLException {
        Connection conn = Database.getConnection();
        Customer customer = null;
        String sqlQuery = "SELECT * FROM Customer WHERE CustomerId = ?";
        PreparedStatement prepStatement = conn.prepareStatement(sqlQuery);
        prepStatement.setInt(1, id);
        ResultSet resultSet = prepStatement.executeQuery();
        if (resultSet.next()) {
            int customerId = resultSet.getInt("CustomerId");
            String firstName = resultSet.getString("FirstName");
            String lastName = resultSet.getString("LastName");
            String company = resultSet.getString("Company");
            String address = resultSet.getString("Address");
            String city = resultSet.getString("City");
            String state = resultSet.getString("State");
            String country = resultSet.getString("Country");
            String postalCode = resultSet.getString("PostalCode");
            String phone = resultSet.getString("Phone");
            String fax = resultSet.getString("Fax");
            String email = resultSet.getString("Email");
            int supportRepId = resultSet.getInt("SupportRepId");

            customer = new Customer(customerId, firstName, lastName, company, address, city, state, country, postalCode, phone, fax, email, supportRepId);
        }
        return customer;
    }

    @Override
    public List<Customer> getAll() throws SQLException {
        return null;
    }

    @Override
    public int save(Customer customer) throws SQLException {
        return 0;
    }

    @Override
    public int insert(Customer customer) throws SQLException {
        return 0;
    }

    @Override
    public int update(Customer customer) throws SQLException {
        return 0;
    }

    @Override
    public int delete(Customer customer) {
        return 0;
    }
}
