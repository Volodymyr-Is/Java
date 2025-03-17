package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductBusinessImpl {
    private ProductService productService;

    public ProductBusinessImpl(ProductService productService) {
        this.productService = productService;
    }

    public List<String> getAvailableProducts(String user) {
        List<String> products = productService.getProducts(user);
        return products.stream().filter(product -> product.contains("Available")).collect(Collectors.toList());
    }
}
