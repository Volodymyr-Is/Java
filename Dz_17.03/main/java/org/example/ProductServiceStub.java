package org.example;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceStub implements ProductService {

    @Override
    public List<String> getProducts(String user) {
        List<String> products = new ArrayList<>();
        products.add("Laptop - Available");
        products.add("Smartphone - Available");
        products.add("Tablet - Out of Stock");
        products.add("Headphones - Available");

        return products;
    }
}
