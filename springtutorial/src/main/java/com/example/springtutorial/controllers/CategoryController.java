package com.example.springtutorial.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.springtutorial.models.Product;
import com.example.springtutorial.services.CategoryService;

@RestController
public class CategoryController {
	@Autowired
	CategoryService categoryService;
	
	public List<Product> getProductsByCategoryId(Long id){
		List<Product> categoryProducts = categoryService.getProductsByCategoryId(id);
		return categoryProducts;
	}
}
