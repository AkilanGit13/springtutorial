package com.example.springtutorial.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springtutorial.models.Category;
import com.example.springtutorial.models.Product;
import com.example.springtutorial.services.CategoryService;

@RestController
@RequestMapping("category")
public class CategoryController {
	@Autowired
	CategoryService categoryService;
	
	public List<Product> getProductsByCategoryId(Long id){
		List<Product> categoryProducts = categoryService.getProductsByCategoryId(id);
		return categoryProducts;
	}
	
	@GetMapping("/{id}")
	public Category getCategoryById(@PathVariable("id") Long id) throws Exception {
		 Category category = categoryService.getCategory(id);
		return category;
	}
}
