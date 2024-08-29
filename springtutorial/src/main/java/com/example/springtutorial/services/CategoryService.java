package com.example.springtutorial.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springtutorial.models.Category;
import com.example.springtutorial.models.Product;
import com.example.springtutorial.repositories.CategoryRepository;
import com.example.springtutorial.repositories.ProductRepository;

@Service
public class CategoryService {
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	public List<Category> getCategories() {
		List<Category> categories = categoryRepository.findAll();
		return categories;
	}
	
	public Category getCategory(Long id) throws Exception {
		Optional<Category> category = categoryRepository.findById(id);
		if(category.isEmpty()) throw new Exception("invalid category id");
		
		return category.get();
	}
	
	public List<Product> getProductsByCategoryId(Long id){
		Optional<Category> category = categoryRepository.findById(id);
		List<Product> categoryProducts = null;
		if(category.isPresent()) {
			Long categoryId = category.get().getId();
//			categoryProducts = productRepository.findByCategoryId(categoryId);
		}
		return categoryProducts;
	}
}
