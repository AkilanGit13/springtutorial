package com.example.springtutorial.services;

import java.util.List;

import com.example.springtutorial.dtos.ProductDTO;
import com.example.springtutorial.exceptions.InvalidProductIdException;
import com.example.springtutorial.models.Product;

public interface ProductServiceByDB {
	public Product findProductByTitle(String title);
	Product updateProduct(Long id, Product product) throws InvalidProductIdException;
	List<Product> getProducts();
	Product getProductById(Long id) throws InvalidProductIdException;
	Product saveProduct(Product product);
	Product replaceProduct(Long id, ProductDTO productDTO);
	Product deleteProduct(long id);
}
