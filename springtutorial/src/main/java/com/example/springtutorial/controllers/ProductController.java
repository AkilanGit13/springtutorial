package com.example.springtutorial.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springtutorial.dtos.ProductDTO;
import com.example.springtutorial.exceptions.InvalidProductIdException;
import com.example.springtutorial.models.Product;
import com.example.springtutorial.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable("id") long id) throws InvalidProductIdException {
		Product product = productService.getProductById(id); 
		return product;
	}
	
	@GetMapping
	public List<Product> getProducts(){
		List<Product> products = productService.getProducts();
		return products;
	}
	
	@PatchMapping("/{id}")
	public Product updateProduct(@PathVariable("id") Long id, @RequestBody ProductDTO productDTO) {
		return productService.updateProduct(id, productDTO);
	}
	
	@PutMapping("/{id}")
	public Product replaceProduct(@PathVariable("id") Long id, @RequestBody ProductDTO productDTO) {
		return productService.replaceProduct(id, productDTO);
	}
}
