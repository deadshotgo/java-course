package org.test;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    /*
        Мета тесту: Перевірити моделі корзини та замолення

        1. Створити корзину
        2. Додати продукти
        3. Отримати всі продукти
        4. Перевірити чи єсть в замовленні додані продукти
        5. Успіх - статус pending
    */
    @Test
    void createOrder(){
        Cart cart = new Cart();

        Product product1 = new Product(1, "product - 1", 43.83);
        Product product2 = new Product(2, "product - 2", 89.74);

        cart.addProduct(product1);
        cart.addProduct(product2);

        Order order = new Order(cart.getProducts());

        List<Product> productsInOrder = order.getProducts();

        assertTrue(productsInOrder.contains(product1));
        assertTrue(productsInOrder.contains(product2));

        assertEquals("pending", order.getStatus());
    }

    /*
        Мета тесту: Перевірити статуси замовлень

        1. Створити корзини
        2. Створити 6 продуктів
        3. Додати до корзини
        4. Створити замовлення
        5. Зробити одне замовлення успішним
    */
    @Test
    void getStatus() {
        Cart cart1 = new Cart();
        Cart cart2 = new Cart();

        Product product1 = new Product(1, "product-1", 30.32);
        Product product2 = new Product(2, "product-2", 98123.3);
        Product product3 = new Product(3, "product-3", 464.4);
        Product product4 = new Product(4, "product-4", 932.6);
        Product product5 = new Product(4, "product-5", 932.6);
        Product product6 = new Product(4, "product-6", 932.6);

        cart1.addProduct(product1);
        cart1.addProduct(product2);
        cart2.addProduct(product3);
        cart2.addProduct(product4);
        cart1.addProduct(product5);
        cart2.addProduct(product6);

        Order order1 = new Order(cart1.getProducts());
        Order order2 = new Order(cart2.getProducts());
        order2.setStatus("success");
        assertEquals("pending", order1.getStatus());
        assertEquals("success", order2.getStatus());
    }
}
