/**
 * Implementation of the CustomerDAO interface for accessing and managing customer data in the database.
 * Provides methods to perform CRUD (Create, Read, Update, Delete) operations specific to customers.
 */
package org.music.application.database.management.customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

        Database.closePreparedStatement(prepStatement);
        Database.closeConnection(conn);

        return customer;
    }

    /**
     * Retrieves all customers from the database.
     *
     * @return A list containing all customer objects retrieved from the database.
     * @throws SQLException If an SQL exception occurs while accessing the database.
     */
    @Override
    public List<Customer> getAll() throws SQLException {
        Connection conn = Database.getConnection();
        List<Customer> customers = new ArrayList<>();
        String sqlQuery = "SELECT * FROM Customer";
        PreparedStatement prepStatement = conn.prepareStatement(sqlQuery);
        ResultSet resultSet = prepStatement.executeQuery();
        while (resultSet.next()) {
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

            Customer customer = new Customer(customerId, firstName, lastName, company, address, city, state, country, postalCode, phone, fax, email, supportRepId);
            customers.add(customer);
        }

        Database.closePreparedStatement(prepStatement);
        Database.closeConnection(conn);

        return customers;
    }

    @Override
    public int save(Customer customer) throws SQLException {
        return 0;
    }

    /**
     * Inserts a new customer into the database.
     *
     * @param customer The customer object to insert into the database.
     * @return The number of rows affected by the insert operation.
     * @throws SQLException If an SQL exception occurs while accessing the database.
     */
    @Override
    public int insert(Customer customer) throws SQLException {
        Connection conn = Database.getConnection();
        String sqlQuery = "INSERT INTO Customer (CustomerId, FirstName, LastName, Company, Address, City, State, Country, PostalCode, Phone, Fax, Email, SupportRepId) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement prepStatement = conn.prepareStatement(sqlQuery);

        prepStatement.setInt(1, customer.getCustomerId());
        prepStatement.setString(2, customer.getFirstName());
        prepStatement.setString(3, customer.getLastName());
        prepStatement.setString(4, customer.getCompany());
        prepStatement.setString(5, customer.getAddress());
        prepStatement.setString(6, customer.getCity());
        prepStatement.setString(7, customer.getState());
        prepStatement.setString(8, customer.getCountry());
        prepStatement.setString(9, customer.getPostalCode());
        prepStatement.setString(10, customer.getPhone());
        prepStatement.setString(11, customer.getFax());
        prepStatement.setString(12, customer.getEmail());
        prepStatement.setInt(13, customer.getSupportRepId());

        int result = prepStatement.executeUpdate();

        Database.closePreparedStatement(prepStatement);
        Database.closeConnection(conn);

        return result;
    }

    /**
     * Updates an existing customer in the database with the provided customer information.
     *
     * @param customer The updated customer object containing new information.
     * @return The number of rows affected by the update operation.
     * @throws SQLException If an SQL exception occurs while accessing the database.
     */
    @Override
    public int update(Customer customer) throws SQLException {
        Connection conn = Database.getConnection();
        String sqlQuery = "UPDATE Customer SET FirstName = ?, LastName = ?, Company = ?, Address = ?, City = ?, State = ?, Country = ?, PostalCode = ?, Phone = ?, Fax = ?, Email = ?, SupportRepId = ? WHERE CustomerId = ?";
        PreparedStatement prepStatement = conn.prepareStatement(sqlQuery);

        prepStatement.setString(1, customer.getFirstName());
        prepStatement.setString(2, customer.getLastName());
        prepStatement.setString(3, customer.getCompany());
        prepStatement.setString(4, customer.getAddress());
        prepStatement.setString(5, customer.getCity());
        prepStatement.setString(6, customer.getState());
        prepStatement.setString(7, customer.getCountry());
        prepStatement.setString(8, customer.getPostalCode());
        prepStatement.setString(9, customer.getPhone());
        prepStatement.setString(10, customer.getFax());
        prepStatement.setString(11, customer.getEmail());
        prepStatement.setInt(12, customer.getSupportRepId());
        prepStatement.setInt(13, customer.getCustomerId());

        int result = prepStatement.executeUpdate();

        Database.closePreparedStatement(prepStatement);
        Database.closeConnection(conn);

        return result;
    }

    @Override
    public int delete(Customer customer) {
        return 0;
    }
}
