package com.arthur.review_springboot.controller;

import com.arthur.review_springboot.dto.ProductRequest;
import com.arthur.review_springboot.model.Product;
import com.arthur.review_springboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ProductController {

    @Autowired
    public ProductService productService;

    // Create
    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody @Valid ProductRequest productRequest) {
        // 新增商品
        Integer productId = productService.createProduct(productRequest);

        // 取得新增完的商品資訊
        Product product = productService.getProductById(productId);

        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    // Read
    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer productId) {
        // 取得商品資訊
        Product product = productService.getProductById(productId);

        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    // Update
    // Delete
}
