package ru.netology.product;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {

    @Test
    void shouldGetManufacturer() {
        Smartphone first = new Smartphone(1, "6051G Soul 1/16GB", 4980, "BQ");
        String expected = "BQ";
        String actual = first.getManufacturer();
        assertEquals(expected, actual);
    }

    @Test
    void testEquals() {
        Smartphone first = new Smartphone(1, "6051G Soul 1/16GB", 4980, "BQ");
        Smartphone second = new Smartphone(1, "6051G Soul 1/16GB", 4980, "BQ");
        assertEquals(first, second);
    }

}