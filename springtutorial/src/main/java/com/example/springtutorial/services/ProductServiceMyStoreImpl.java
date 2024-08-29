package com.example.springtutorial.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springtutorial.dtos.ProductDTO;
import com.example.springtutorial.exceptions.InvalidProductIdException;
import com.example.springtutorial.models.Category;
import com.example.springtutorial.models.Product;
import com.example.springtutorial.repositories.CategoryRepository;
import com.example.springtutorial.repositories.ProductRepository;

@Service("productServiceMyStoreImpl")
//@Primary
public class ProductServiceMyStoreImpl implements ProductServiceByDB{
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Override
	public List<Product> getProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(Long id) throws InvalidProductIdException {
		Product product = productRepository.findById(id)
											.orElseThrow(()->new InvalidProductIdException(id, "Invalid Product Id"));
		
		return product;
	}

	@Override
	public Product saveProduct(Product product) {
		Category category = product.getCategory();
		if(category.getId() == null) {
			categoryRepository.save(category);
		}
		Product savedProduct = productRepository.save(product);
		return savedProduct;
	}

	@Override
	public Product updateProduct(Long id, Product product) throws InvalidProductIdException {
		Optional<Product> optionalProduct = productRepository.findById(id);
		
		Product savedProduct = optionalProduct.orElseThrow(()-> new InvalidProductIdException(id, "invalid product id"));
	 	if (product.getTitle() != null) {
            savedProduct.setTitle(product.getTitle());
        }
        if (product.getPrice() != null) {
            savedProduct.setPrice(product.getPrice());
        }
        if (product.getCategory() != null) {
            savedProduct.setCategory(product.getCategory());
        }
        if (product.getDescription() != null) {
            savedProduct.setDescription(product.getDescription());
        }
        if (product.getImage() != null) {
            savedProduct.setImage(product.getImage());
        }

        return productRepository.save(savedProduct);
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
	
	@Override
	public Product findProductByTitle(String title) {
		productRepository.findByTitle(title);
		return null;
	}


}
