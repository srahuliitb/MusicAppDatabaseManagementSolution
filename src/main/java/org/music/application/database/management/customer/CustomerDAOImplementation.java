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

    // CRUD - Retrieve all
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
            String sqlQuery = "DELETE FROM Customer WHERE CustomerId = ?";
            PreparedStatement prepStatement = conn.prepareStatement(sqlQuery);
            prepStatement.setInt(1, customer.getCustomerId());
            int result = prepStatement.executeUpdate();

            Database.closePreparedStatement(prepStatement);
            Database.closeConnection(conn);

            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
