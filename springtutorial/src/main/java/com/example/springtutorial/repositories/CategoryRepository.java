package com.example.springtutorial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springtutorial.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
