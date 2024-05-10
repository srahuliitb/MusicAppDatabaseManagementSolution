package org.music.application.database.management.customer;

import java.sql.SQLException;
import java.util.List;

/**
 * Data Access Object (DAO) interface for generic database operations.
 * This interface defines methods for accessing, manipulating, and managing data in the database.
 * It provides basic CRUD (Create, Read, Update, Delete) operations.
 *
 * @param <T> The type of object this DAO operates on.
 */
public interface DAO<T> {

    /**
     * Retrieves an object from the database based on its unique identifier.
     *
     * @param id The unique identifier of the object to retrieve.
     * @return The retrieved object.
     * @throws SQLException If an SQL exception occurs while accessing the database.
     */
    T get(int id) throws SQLException;

    /**
     * Retrieves all objects of type T from the database.
     *
     * @return A list containing all objects of type T retrieved from the database.
     * @throws SQLException If an SQL exception occurs while accessing the database.
     */
    List<T> getAll() throws SQLException;

    /**
     * Saves an object to the database.
     *
     * @param t The object to save.
     * @return The number of rows affected by the save operation.
     * @throws SQLException If an SQL exception occurs while accessing the database.
     */
    int save(T t) throws SQLException;

    /**
     * Inserts an object into the database.
     *
     * @param t The object to insert.
     * @return The number of rows affected by the insert operation.
     * @throws SQLException If an SQL exception occurs while accessing the database.
     */
    int insert(T t) throws SQLException;

    /**
     * Updates an existing object in the database.
     *
     * @param t The object to update.
     * @return The number of rows affected by the update operation.
     * @throws SQLException If an SQL exception occurs while accessing the database.
     */
    int update(T t) throws SQLException;

    /**
     * Deletes an object from the database.
     *
     * @param t The object to delete.
     * @return The number of rows affected by the delete operation.
     */
    int delete(T t);
}

