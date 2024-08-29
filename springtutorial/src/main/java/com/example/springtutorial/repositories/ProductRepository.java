package com.example.springtutorial.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springtutorial.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	Product findByTitle(String title);


}
