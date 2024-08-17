package com.example.springtutorial.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public Product getProductById(@PathVariable("id") long id) {
		Product product = productService.getProductById(id); 
		return product;
	}
	
	@GetMapping
	public List<Product> getProducts(){
		List<Product> products = productService.getProducts();
		return products;
	}
}
