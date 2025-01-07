package com.excelr.springboot_rest_api_backend_project.service;

import java.util.List;

import com.excelr.springboot_rest_api_backend_project.Product;



public interface ProductService {
	public String upsert(Product product);
	//upsert in one method in that u can insert and update both


public Product getById(Integer id);
public List<Product> getAllProducts();
public String deleteById(Integer id);
}
