package com.example.springtutorial.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import com.example.springtutorial.dtos.ProductDTO;
import com.example.springtutorial.models.Category;
import com.example.springtutorial.models.Product;

@Service
public class ProductServiceFakeStoreImpl implements ProductService{
	public RestTemplate restTemplate;
	
	public ProductServiceFakeStoreImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	private Product convertFakeStoreProductDTOToProduct(ProductDTO fakeStoreProductDTO) {
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
		ProductDTO[] list = restTemplate.getForObject("https://fakestoreapi.com/products", ProductDTO[].class);
		
		List<Product> products = new ArrayList<>();
		
		for(ProductDTO i : list) {
			products.add(convertFakeStoreProductDTOToProduct(i));
		}
		
		return products;
	}

	@Override
	public Product getProductById(Long id) {
		ProductDTO fakeStoreProductDTO = restTemplate.getForObject("https://fakestoreapi.com/products/"+id, ProductDTO.class);
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
	public Product updateProduct(Long id, ProductDTO productDTO) {
		RequestCallback requestCallback = restTemplate.httpEntityCallback(productDTO, ProductDTO.class);
		HttpMessageConverterExtractor<ProductDTO> responseExtractor =
				new HttpMessageConverterExtractor<>(ProductDTO.class, restTemplate.getMessageConverters());
		ProductDTO updatedProductDTO = restTemplate.execute("https://fakestoreapi.com/products/"+id, HttpMethod.PUT, requestCallback, responseExtractor);
		
		Product product = convertFakeStoreProductDTOToProduct(updatedProductDTO);
		
		return product;
	}

	@Override
	public Product replaceProduct(Long id, ProductDTO productDTO) {
		RequestCallback requestCallback = restTemplate.httpEntityCallback(productDTO, ProductDTO.class);
		HttpMessageConverterExtractor<ProductDTO> responseExtractor =
				new HttpMessageConverterExtractor<>(ProductDTO.class, restTemplate.getMessageConverters());
		ProductDTO updatedProductDTO = restTemplate.execute("https://fakestoreapi.com/products/"+id, HttpMethod.PATCH, requestCallback, responseExtractor);
		
		Product product = convertFakeStoreProductDTOToProduct(updatedProductDTO);
		
		return product;
	}

	@Override
	public Product deleteProduct(long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
