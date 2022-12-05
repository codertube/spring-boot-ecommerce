package com.backend.ecommerce.controller;

import com.backend.ecommerce.entity.Product;
import com.backend.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping()
    public ResponseEntity<?> getAllProducts() {
        List<Product> products = productService.getProducts();
        if (!products.isEmpty()) {
            return new ResponseEntity<>(products, HttpStatus.OK);
        }
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable(value = "id") Long id) {
        Product product = productService.getProductById(id);
        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
        return null;
    }

    @GetMapping("/categories/{categoryId}")
    public ResponseEntity<?> getProductsByCategory(@PathVariable(value = "categoryId") Long categoryId) {
        List<Product> products = productService.getProductsByCategory(categoryId);
        if (products != null && !products.isEmpty()) {
            return new ResponseEntity<>(products, HttpStatus.OK);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> removeProduct(@PathVariable("id") Long id) {
        Product product = productService.getProductById(id);
        if (product != null) {
            productService.removeProduct(product);
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
        return null;
    }
}
