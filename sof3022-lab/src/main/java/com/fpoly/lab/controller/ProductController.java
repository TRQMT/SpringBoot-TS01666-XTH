package com.fpoly.lab.controller;

import com.fpoly.lab.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final List<Product> productList = new ArrayList<>();

    public ProductController() {
        productList.add(new Product(1L, "Laptop Acer Nitro", 18500000.0));
        productList.add(new Product(2L, "Chuột Logitech G102", 400000.0));
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productList);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        product.setId((long) (productList.size() + 1));
        productList.add(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }
}