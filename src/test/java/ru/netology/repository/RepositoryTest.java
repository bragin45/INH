package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.product.Book;
import ru.netology.product.Smartphone;


import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {

    @Test
    public void shouldSaveBook() {
        Book first = new Book(1, "1984", 390, "Оруэлл Джордж");
        Repository repo = new Repository();
        repo.save(first);
        int expected = 1;
        int actual = repo.findAll().length;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSaveSmartphone() {
        Smartphone first = new Smartphone(1, "6051G Soul 1/16GB", 4980, "BQ");
        Repository repo = new Repository();
        repo.save(first);
        int expected = 1;
        int actual = repo.findAll().length;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdBook() {
        Book first = new Book(1, "1984", 390, "Оруэлл Джордж");
        Book second = new Book(2, "Татуировщик из Освенцима", 192, "Моррис Хезер");
        Repository repo = new Repository();
        repo.save(first);
        repo.save(second);
        repo.removeById(1);
        int expected = 1;
        int actual = repo.findAll().length;
        assertEquals(expected, actual);
    }

}