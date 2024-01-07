package org.test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {

    /*
        Мета: Перевірити додавання продукта до корзини

        1. Створити корзину
        2. Додати продукт
        3. Перевірити чи він додався
        4. Вивести результат
    */
    @org.junit.jupiter.api.Test
    void addProduct() {
        Cart cart = new Cart();
        Product product = new Product(1, "product - 1", 44.23);
        cart.addProduct(product);
        List<Product> productsInCart = cart.getProducts();
        assertTrue(productsInCart.contains(product));
    }

    /*
       Мета: Перевірити видалення продукта в корзині

       1. Створити корзину
       2. Створити та Додати продукт
       3. Видалити продукт
       4. Отримати всі продукти та перевірити успішність тесту
       5. Вивести результат
   */
    @org.junit.jupiter.api.Test
    void removeProduct() {
        Cart cart = new Cart();
        Product product = new Product(1, "product - 2", 49.53);
        cart.addProduct(product);
        cart.removeItemCart(product);
        List<Product> productsInCart = cart.getProducts();
        assertFalse(productsInCart.contains(product));
    }
}
