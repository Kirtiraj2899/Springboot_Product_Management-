package com.excelr.springboot_rest_api_backend_project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelr.springboot_rest_api_backend_project.Product;
import com.excelr.springboot_rest_api_backend_project.ProductRepo.ProductReposetory;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductReposetory productRepo;

    // Create or Update Product
    @Override
    public String upsert(Product product) {
        productRepo.save(product);
        return "Product saved/updated successfully";
    }

    // Get Product by ID
    @Override
    public Product getById(Integer id) {
        Optional<Product> findById = productRepo.findById(id);
        if (findById.isPresent()) {
            return findById.get();
        }
        return null;
    }

    // Get All Products
    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    // Delete Product by ID
    @Override
    public String deleteById(Integer id) {
        if (productRepo.existsById(id)) {
            productRepo.deleteById(id);
            return "Product deleted successfully";
        } else {
            return "No product found with the given ID";
        }
    }
}
