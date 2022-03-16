package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.repository.Repository;
import ru.netology.product.Book;
import ru.netology.product.Smartphone;
import ru.netology.product.Product;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    private Repository repository = new Repository();
    private Manager manager = new Manager(repository);

    Product product1 = new Book(1, "1984", 390, "Оруэлл Джордж");
    Product product2 = new Book(2, "Куда приводят мечты", 166, "Матесон Ричард");
    Product product3 = new Book(3, "Эмма", 210, "Остен Джейн");
    Product product4 = new Book(4, "Татуировщик из Освенцима", 210, "Моррис Хезер");
    Product product5 = new Book(5, "Творцы совпадений", 166, "Блум Йоав");
    Product product6 = new Smartphone(6, "POP 5 LTE 2/32GB", 9499, "Tecno");
    Product product7 = new Smartphone(7, "6051G Soul 1/16GB", 4980, "BQ");
    Product product8 = new Smartphone(8, "Redmi 9A 2/32GB", 11991, "Xiaomi");
    Product product9 = new Smartphone(9, "Y31 4/64GB", 15999, "Vivo");
    Product product10 = new Smartphone(10, "Blade L210 1/32GB", 5983, "ZTE");

    @Test
    public void shouldSaveOneBook() {
        repository.save(product1);

        Product[] expected = new Product[]{product1};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveOneSmartphone() {
        repository.save(product6);

        Product[] expected = new Product[]{product6};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveBookById() {
        repository.save(product1);
        repository.removeById(1);

        Product[] expected = new Product[]{};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void removeSmartphoneById() {
        repository.save(product6);

        repository.removeById(6);

        Product[] expected = new Product[]{};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddOneBookWithManager() {
        manager.add(product1);
        Product[] expected = {product1};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddOneSmartphoneWithManager() {
        manager.add(product6);
        Product[] expected = {product6};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByProductName() {
        manager.add(product1);
        manager.add(product7);
        Product[] actual = manager.searchBy("1984");
        Product[] expected = {product1};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByBookName() {
        manager.add(product3);
        manager.add(product4);
        Product[] actual = manager.searchBy("ма");
        Product[] expected = {product3, product4};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByBookAuthor() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
        manager.add(product5);
        Product[] actual = manager.searchBy("Кинг");
        Product[] expected = {};
        assertArrayEquals(expected, actual);
    }

}