package com.example.springtutorial.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springtutorial.models.Product;

@Service
public interface ProductService {
	List<Product> getProducts();
	Product getProductById(long id);
	Product saveProduct(Product product);
	Product updateProduct(long id, Product product);
	Product replaceProduct(long id, Product product);
	Product deleteProduct(long id);
}
