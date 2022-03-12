package ru.netology.product;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void shouldGetAuthor() {
        Book first = new Book(1, "Татуировщик из Освенцима", 192, "Моррис Хезер");
        String expected = "Моррис Хезер";
        String actual = first.getAuthor();
        assertEquals(expected, actual);
    }

    @Test
    void testEquals() {
        Book first = new Book(1, "Татуировщик из Освенцима", 192, "Моррис Хезер");
        Book second = new Book(1, "Татуировщик из Освенцима", 192, "Моррис Хезер");
        assertEquals(first, second);
    }

}