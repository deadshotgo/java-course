package org.test;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> products;

    public Cart() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeItemCart(Product product) {
        products.remove(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void removeItemsCart() {
        products.clear();
    }
}
