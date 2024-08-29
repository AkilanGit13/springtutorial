package com.example.springtutorial.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springtutorial.dtos.ProductDTO;
import com.example.springtutorial.exceptions.InvalidProductIdException;
import com.example.springtutorial.models.Product;
import com.example.springtutorial.services.ProductService;
import com.example.springtutorial.services.ProductServiceByDB;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	ProductServiceByDB productService;
	
	public ProductController(@Qualifier("productServiceMyStoreImpl") ProductServiceByDB productService) {
		this.productService = productService;
	}
	
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable("id") long id) throws InvalidProductIdException {
		Product product = productService.getProductById(id); 
		return product;
	}
	
//	@GetMapping("/{title}")
//	public Product getProductByTitle(@PathVariable("title") String title) throws InvalidProductIdException {
//		Product product = productService. (title); 
//		return product;
//	}
	
	@GetMapping
	public List<Product> getProducts(){
		List<Product> products = productService.getProducts();
		return products;
	}
	
	@PostMapping
	public Product saveProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}
	
	@PatchMapping("/{id}")
	public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product) throws InvalidProductIdException {
		product.setId(id);
		return productService.updateProduct(id, product);
	}
	
	@PutMapping("/{id}")
	public Product replaceProduct(@PathVariable("id") Long id, @RequestBody ProductDTO productDTO) {
		return productService.replaceProduct(id, productDTO);
	}
}
