package com.example.springtutorial.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.springtutorial.dtos.FakeStoreProductDTO;
import com.example.springtutorial.models.Category;
import com.example.springtutorial.models.Product;

@Service
public class ProductServiceFakeStoreImpl implements ProductService{
	public RestTemplate restTemplate;
	
	public ProductServiceFakeStoreImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	private Product convertFakeStoreProductDTOToProduct(FakeStoreProductDTO fakeStoreProductDTO) {
		Product product = new Product();
		product.setId(fakeStoreProductDTO.getId());
		product.setDescription(fakeStoreProductDTO.getDescription());
		product.setTitle(fakeStoreProductDTO.getTitle());
		product.setPrice(fakeStoreProductDTO.getPrice());
		product.setImage(fakeStoreProductDTO.getImage());
		
		Category category = new Category();
		category.setCategory(fakeStoreProductDTO.getCategory());
		product.setCategory(category);
		
		return product;
	}
	
	@Override
	public List<Product> getProducts() {
		FakeStoreProductDTO[] list = restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDTO[].class);
		
		List<Product> products = new ArrayList<>();
		
		for(FakeStoreProductDTO i : list) {
			products.add(convertFakeStoreProductDTOToProduct(i));
		}
		
		return products;
	}

	@Override
	public Product getProductById(long id) {
		FakeStoreProductDTO fakeStoreProductDTO = restTemplate.getForObject("https://fakestoreapi.com/products/"+id, FakeStoreProductDTO.class);
		if(fakeStoreProductDTO == null) {
			return null;
		}
		Product product = convertFakeStoreProductDTOToProduct(fakeStoreProductDTO);
		return product;
	}

	@Override
	public Product saveProduct(Product product) {
		return null;
	}

	@Override
	public Product updateProduct(long id, Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product replaceProduct(long id, Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product deleteProduct(long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
