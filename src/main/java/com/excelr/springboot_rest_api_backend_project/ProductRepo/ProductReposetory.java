package com.excelr.springboot_rest_api_backend_project.ProductRepo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.excelr.springboot_rest_api_backend_project.Product;

@Repository
public interface ProductReposetory extends JpaRepository<Product, Serializable> {
			//this is used to perform operatin with database
			//this repositoty extends the properties from jpa repository
			//advantage of data jpa is provide readiable methods for crud opration
}
