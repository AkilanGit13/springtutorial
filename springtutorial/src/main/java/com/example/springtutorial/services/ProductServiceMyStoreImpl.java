package com.example.springtutorial.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.springtutorial.dtos.ProductDTO;
import com.example.springtutorial.exceptions.InvalidProductIdException;
import com.example.springtutorial.models.Product;
import com.example.springtutorial.repositories.ProductRepository;

@Service
@Primary
public class ProductServiceMyStoreImpl implements ProductService{
	@Autowired
	ProductRepository productRepository;
	
	@Override
	public List<Product> getProducts() {
		productRepository.findAll();
		return null;
	}

	@Override
	public Product getProductById(Long id) throws InvalidProductIdException {
		Product product = productRepository.findById(id)
											.orElseThrow(()->new InvalidProductIdException(id, "Invalid Product Id"));
		return product;
	}

	@Override
	public Product saveProduct(Product product) {
		Product savedProduct = productRepository.save(product);
		return savedProduct;
	}

	@Override
	public Product updateProduct(Long id, ProductDTO productDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product replaceProduct(Long id, ProductDTO productDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product deleteProduct(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
