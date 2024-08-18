package com.example.springtutorial.services;

import java.util.List;

import com.example.springtutorial.dtos.ProductDTO;
import com.example.springtutorial.models.Product;

public interface ProductService {
	List<Product> getProducts();
	Product getProductById(Long id);
	Product saveProduct(Product product);
	Product updateProduct(Long id, ProductDTO productDTO);
	Product replaceProduct(Long id, ProductDTO productDTO);
	Product deleteProduct(long id);
}
