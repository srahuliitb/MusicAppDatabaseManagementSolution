/**
 * Represents a customer in the Music App database management system.
 * Each customer has a unique identifier along with various personal and contact information.
 */
package org.music.application.database.management.customer;

import java.util.Objects;

public class Customer {

    private final int customerId;  // Unique identifier for the customer
    private String firstName;  // First name of the customer
    private String lastName;  // Last name of the customer
    private String company;  // Company name of the customer
    private String address;  // Address of the customer
    private String city;  // City of the customer
    private String state;  // State of the customer
    private String country;  // Country of the customer
    private String postalCode;  // Postal code of the customer
    private String phone;  // Phone number of the customer
    private String fax;  // Fax number of the customer
    private String email;  // Email address of the customer
    private int SupportRepId;  // Identifier of the support representative assigned to the customer

    /**
     * Constructs a new Customer with the specified details.
     *
     * @param customerId   The unique identifier for the customer.
     * @param firstName    The first name of the customer.
     * @param lastName     The last name of the customer.
     * @param company      The company name of the customer.
     * @param address      The address of the customer.
     * @param city         The city of the customer.
     * @param state        The state of the customer.
     * @param country      The country of the customer.
     * @param postalCode   The postal code of the customer.
     * @param phone        The phone number of the customer.
     * @param fax          The fax number of the customer.
     * @param email        The email address of the customer.
     * @param supportRepId The identifier of the support representative assigned to the customer.
     */
    public Customer(int customerId, String firstName, String lastName, String company, String address, String city, String state, String country, String postalCode, String phone, String fax, String email, int supportRepId) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.address = address;
        this.city = city;
        this.state = state;
        this.country = country;
        this.postalCode = postalCode;
        this.phone = phone;
        this.fax = fax;
        this.email = email;
        this.SupportRepId = supportRepId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSupportRepId() {
        return SupportRepId;
    }

    public void setSupportRepId(int supportRepId) {
        SupportRepId = supportRepId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer customer)) return false;
        return customerId == customer.customerId && Objects.equals(phone, customer.phone) && Objects.equals(email, customer.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, phone, email);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", company='" + company + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", phone='" + phone + '\'' +
                ", fax='" + fax + '\'' +
                ", email='" + email + '\'' +
                ", SupportRepId='" + SupportRepId + '\'' +
                '}';
    }
}
