package ru.netology.manager;

import ru.netology.product.Book;
import ru.netology.product.Product;
import ru.netology.product.Smartphone;
import ru.netology.repository.Repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    private Repository repository = new Repository();
    private Manager manager = new Manager(repository);

    Product product1 = new Book(1, "1984", 390, "Оруэлл Джордж");
    Product product2 = new Book(2, "Куда приводят мечты", 166, "Матесон Ричард");
    Product product3 = new Book(3, "Эмма", 210, "Остен Джейн");
    Product product4 = new Book(4, "Татуировщик из Освенцима", 192, "Моррис Хезер");
    Product product5 = new Book(5, "Творцы совпадений", 166, "Блум Йоав");
    Product product6 = new Smartphone(6, "POP 5 LTE 2/32GB", 9499, "Tecno");
    Product product7 = new Smartphone(7, "6051G Soul 1/16GB", 4980, "BQ");
    Product product8 = new Smartphone(8, "Redmi 9A 2/32GB", 11991, "Xiaomi");
    Product product9 = new Smartphone(9, "Y31 4/64GB", 15999, "Vivo");
    Product product10 = new Smartphone(10, "Blade L210 1/32GB", 5983, "ZTE");

    @BeforeEach
    void setup() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
        manager.add(product5);
        manager.add(product6);
        manager.add(product7);
        manager.add(product8);
        manager.add(product9);
        manager.add(product10);
    }

    @Test
    void shouldSearchByBookName(){
        Product[]actual = manager.searchBy("Куда приводят мечты");
        Product[]excepted = {new Book(2, "Куда приводят мечты", 166, "Матесон Ричард")};

        assertArrayEquals(excepted, actual);
    }

    @Test
    void shouldSearchByBookAuthor(){
        Product[]actual =manager.searchBy("Оруэлл Джордж");
        Product[]excepted = {new Book(1, "1984", 390, "Оруэлл Джордж")};

        assertArrayEquals(excepted, actual);
    }

    @Test
    void shouldSearchBySmartphoneName(){
        Product[]actual = manager.searchBy("6051G Soul 1/16GB");
        Product[]expected = {new Smartphone(7, "6051G Soul 1/16GB", 4980,"BQ")};

        assertArrayEquals(expected,actual);
    }

    @Test
    void shouldSearchBySmartphoneManufacturer(){
        Product[]actual = manager.searchBy("Vivo");
        Product[]expected = {new Smartphone(9,"Y31 4/64GB", 15999,"Vivo")};

        assertArrayEquals(expected,actual);
    }

}