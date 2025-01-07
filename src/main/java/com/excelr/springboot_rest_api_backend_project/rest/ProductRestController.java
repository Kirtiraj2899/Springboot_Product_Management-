package com.excelr.springboot_rest_api_backend_project.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.excelr.springboot_rest_api_backend_project.Product;
import com.excelr.springboot_rest_api_backend_project.service.ProductService;

@RestController
public class ProductRestController {

    @Autowired
    private ProductService productService;

    // Create Product
    @PostMapping("/product")
    public ResponseEntity<String> createProduct(@RequestBody Product product) {
        String status = productService.upsert(product);
        return new ResponseEntity<>(status, HttpStatus.CREATED);
    }

    // Get Product by ID
    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer id) {
        Product product = productService.getById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    // Get All Products
    @GetMapping("/product")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> allProducts = productService.getAllProducts();
        return new ResponseEntity<>(allProducts, HttpStatus.OK);
    }

    // Update Product
    @PutMapping("/product")
    public ResponseEntity<String> updateProduct(@RequestBody Product product) {
        String status = productService.upsert(product);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    // Delete Product by ID
    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Integer id) {
        String status = productService.deleteById(id);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
}
