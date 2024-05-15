package org.music.application.database.management.customer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer(14, "Mark", "Philips", "Telus",
                "8210 111 ST NW", "Edmonton", "AB", "Canada", "T6G 2C7",
                "+1 (780) 434-4554", "+1 (780) 434-5565", "mphilips12@shaw.ca", 5);
    }

    @Test
    void getCustomerIdShouldReturn14() {
        assertEquals(14, customer.getCustomerId());
    }

    @Test
    void getFirstNameShouldReturnMark() {
        assertEquals("Mark", customer.getFirstName());
    }

    @Test
    void setFirstNameShouldSetFrank() {
        customer.setFirstName("Frank");
        assertEquals("Frank", customer.getFirstName());
    }

    @Test
    void getLastNameShouldReturnPhilips() {
        assertEquals("Philips", customer.getLastName());
    }

    @Test
    void setLastNameShouldSetJohnson() {
        customer.setLastName("Johnson");
        assertEquals("Johnson", customer.getLastName());
    }

    @Test
    void getCompanyShouldReturnTelus() {
        assertEquals("Telus", customer.getCompany());
    }

    @Test
    void setCompanyShouldSetTesla() {
        customer.setCompany("Tesla");
        assertEquals("Tesla", customer.getCompany());
    }

    @Test
    void getAddressShouldReturn8210_111_ST_NW() {
        assertEquals("8210 111 ST NW", customer.getAddress());
    }

    @Test
    void setAddressShouldSetPearlHarbour() {
        customer.setAddress("Pearl Harbour");
        assertEquals("Pearl Harbour", customer.getAddress());
    }

    @Test
    void getCityShouldReturnEdmonton() {
        assertEquals("Edmonton", customer.getCity());
    }

    @Test
    void setCityShouldSetToronto() {
        customer.setCity("Toronto");
        assertEquals("Toronto", customer.getCity());
    }

    @Test
    void getStateShouldReturnAB() {
        assertEquals("AB", customer.getState());
    }

    @Test
    void setStateShouldSetNorthCarolina() {
        customer.setState("North Carolina");
        assertEquals("North Carolina", customer.getState());
    }

    @Test
    void getCountryShouldReturnCanada() {
        assertEquals("Canada", customer.getCountry());
    }

    @Test
    void setCountryShouldSetUsa() {
        customer.setCountry("USA");
        assertEquals("USA", customer.getCountry());
    }

    @Test
    void getPostalCodeShouldReturnT6G_2C7() {
        assertEquals("T6G 2C7", customer.getPostalCode());
    }

    @Test
    void setPostalCodeShouldSetNe17Ru() {
        customer.setPostalCode("NE1 7RU");
        assertEquals("NE1 7RU", customer.getPostalCode());
    }

    @Test
    void getPhone() {
        assertEquals("+1 (780) 434-4554", customer.getPhone());
    }

    @Test
    void setPhone() {
        customer.setPhone("+44 (0) 191 208 6000");
        assertEquals("+44 (0) 191 208 6000", customer.getPhone());
    }

    @Test
    void getFax() {
        assertEquals("+1 (780) 434-5565", customer.getFax());
    }

    @Test
    void setFax() {
        customer.setFax("+44 (0) 191 208 6555");
        assertEquals("+44 (0) 191 208 6555", customer.getFax());
    }

    @Test
    void getEmail() {
        assertEquals("mphilips12@shaw.ca", customer.getEmail());
    }

    @Test
    void setEmail() {
        customer.setEmail("mphilips2024@shaw.ca");
        assertEquals("mphilips2024@shaw.ca", customer.getEmail());
    }

    @Test
    void getSupportRepIdShouldReturn5() {
        assertEquals(5, customer.getSupportRepId());
    }

    @Test
    void setSupportRepIdShouldSet333() {
        customer.setSupportRepId(333);
        assertEquals(333, customer.getSupportRepId());
    }
}