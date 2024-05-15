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
    // CRUD - Retrieve one
    /**
     * Retrieves a customer from the database based on the provided customer ID.
     *
     * @param customerId The unique identifier of the customer to retrieve.
     * @return The retrieved customer object.
     * @throws SQLException If an SQL exception occurs while accessing the database.
     */
    @Override
    public Customer get(int customerId) throws SQLException {
        try (Connection conn = Database.getConnection();
             PreparedStatement prepStatement = conn.prepareStatement("SELECT * FROM Customer WHERE CustomerId = ?")) {

            prepStatement.setInt(1, customerId);
            try (ResultSet resultSet = prepStatement.executeQuery()) {
                if (resultSet.next()) {
                    return extractCustomerFromResultSet(resultSet);
                }
            }
        }
        return null; // No customer with given customerId found
    }

    // CRUD - Retrieve all
    /**
     * Retrieves all customers from the database.
     *
     * @return A list containing all customer objects retrieved from the database.
     * @throws SQLException If an SQL exception occurs while accessing the database.
     */
    @Override
    public List<Customer> getAll() throws SQLException {
        List<Customer> customers = new ArrayList<>();
        try (Connection conn = Database.getConnection();
             PreparedStatement prepStatement = conn.prepareStatement("SELECT * FROM Customer");
             ResultSet resultSet = prepStatement.executeQuery()) {

            while (resultSet.next()) {
                    customers.add(extractCustomerFromResultSet(resultSet));
            }
        }
        return customers;
    }

    // CRUD - Create
    /**
     * Inserts a new customer into the database.
     *
     * @param customer The customer object to insert into the database.
     * @return The number of rows affected by the insert operation.
     * @throws SQLException If an SQL exception occurs while accessing the database.
     */
    @Override
    public int insert(Customer customer) throws SQLException {
        String sqlQuery = "INSERT INTO Customer (CustomerId, FirstName, LastName, Company, Address, City, State, Country, PostalCode, Phone, Fax, Email, SupportRepId) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection conn = Database.getConnection();
        PreparedStatement prepStatement = conn.prepareStatement(sqlQuery)) {
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

            return prepStatement.executeUpdate();
        }
    }

    // CRUD - Update
    /**
     * Updates an existing customer in the database with the provided customer information.
     *
     * @param customer The updated customer object containing new information.
     * @return The number of rows affected by the update operation.
     * @throws SQLException If an SQL exception occurs while accessing the database.
     */
    @Override
    public int update(Customer customer) throws SQLException {
        String sqlQuery = "UPDATE Customer SET FirstName = ?, LastName = ?, Company = ?, Address = ?, City = ?, State = ?, Country = ?, PostalCode = ?, Phone = ?, Fax = ?, Email = ?, SupportRepId = ? WHERE CustomerId = ?";
        try (Connection conn = Database.getConnection();
        PreparedStatement prepStatement = conn.prepareStatement(sqlQuery)) {
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

            return prepStatement.executeUpdate();
        }
    }

    // CRUD - Delete
    /**
     * Deletes the specified customer from the database.
     *
     * @param customer The customer object to delete.
     * @return The number of rows affected by the delete operation.
     * @throws RuntimeException If an SQL exception occurs while accessing the database.
     */
    @Override
    public int delete(Customer customer) {
        try {
            Connection conn = Database.getConnection();
            PreparedStatement prepStatement = conn.prepareStatement("DELETE FROM Customer WHERE CustomerId = ?");
            prepStatement.setInt(1, customer.getCustomerId());
            int result = prepStatement.executeUpdate();

            Database.closePreparedStatement(prepStatement);
            Database.closeConnection(conn);

            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Helper function to extract a Customer object from a given ResultSet object.
    /**
     * Extracts a customer object from the given result set.
     *
     * @param resultSet The result set containing the customer data.
     * @return The customer object extracted from the result set.
     * @throws SQLException If an SQL exception occurs while accessing the result set.
     */
    private Customer extractCustomerFromResultSet(ResultSet resultSet) throws SQLException {
        return new Customer(
                resultSet.getInt("CustomerId"),
                resultSet.getString("FirstName"),
                resultSet.getString("LastName"),
                resultSet.getString("Company"),
                resultSet.getString("Address"),
                resultSet.getString("City"),
                resultSet.getString("State"),
                resultSet.getString("Country"),
                resultSet.getString("PostalCode"),
                resultSet.getString("Phone"),
                resultSet.getString("Fax"),
                resultSet.getString("Email"),
                resultSet.getInt("SupportRepId")
        );
    }

    // CRUD - Create or update
    /**
     * Saves a customer by performing either a create or update operation.
     * If the customer object has a valid CustomerId, it updates the existing record in the database.
     * If the customer object does not have a valid CustomerId, it creates a new record in the database.
     *
     * @param customer The customer object to save.
     * @return The number of rows affected. If the customer object was newly created, 1 is returned. If it was updated, the number of updated rows is returned.
     * @throws RuntimeException If a runtime exception occurs while accessing the database.
     */
    @Override
    public int save(Customer customer) {
        try {
            Connection conn = Database.getConnection();
            int result;
            if (customer.getCustomerId() > 0) {
                // Perform an update operation
                String sqlUpdateQuery = "UPDATE Customer SET FirstName = ?, LastName = ?, Company = ?, Address = ?, City = ?, State = ?, Country = ?, PostalCode = ?, Phone = ?, Fax = ?, Email = ?, SupportRepId = ? WHERE CustomerId = ?";
                PreparedStatement updateStatement = conn.prepareStatement(sqlUpdateQuery);
                updateStatement.setString(1, customer.getFirstName());
                updateStatement.setString(2, customer.getLastName());
                updateStatement.setString(3, customer.getCompany());
                updateStatement.setString(4, customer.getAddress());
                updateStatement.setString(5, customer.getCity());
                updateStatement.setString(6, customer.getState());
                updateStatement.setString(7, customer.getCountry());
                updateStatement.setString(8, customer.getPostalCode());
                updateStatement.setString(9, customer.getPhone());
                updateStatement.setString(10, customer.getFax());
                updateStatement.setString(11, customer.getEmail());
                updateStatement.setInt(12, customer.getSupportRepId());
                updateStatement.setInt(13, customer.getCustomerId());

                result = updateStatement.executeUpdate();
                Database.closePreparedStatement(updateStatement);
            } else {
                // Perform a create operation
                String sqlInsertQuery = "INSERT INTO Customer (CustomerId, FirstName, LastName, Company, Address, City, State, Country, PostalCode, Phone, Fax, Email, SupportRepId) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement insertStatement = conn.prepareStatement(sqlInsertQuery);
                insertStatement.setInt(1, customer.getCustomerId());
                insertStatement.setString(2, customer.getFirstName());
                insertStatement.setString(3, customer.getLastName());
                insertStatement.setString(4, customer.getCompany());
                insertStatement.setString(5, customer.getAddress());
                insertStatement.setString(6, customer.getCity());
                insertStatement.setString(7, customer.getState());
                insertStatement.setString(8, customer.getCountry());
                insertStatement.setString(9, customer.getPostalCode());
                insertStatement.setString(10, customer.getPhone());
                insertStatement.setString(11, customer.getFax());
                insertStatement.setString(12, customer.getEmail());
                insertStatement.setInt(13, customer.getSupportRepId());

                result = insertStatement.executeUpdate();
                Database.closePreparedStatement(insertStatement);
            }
            Database.closeConnection(conn);
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
