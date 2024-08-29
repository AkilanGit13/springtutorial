package com.example.springtutorial.models;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity//(name = "products")
@DynamicUpdate
public class Product extends BaseEntity{
	private String title;
	private Double price;
	@ManyToOne(cascade = CascadeType.MERGE)
	private Category category;
	private String description;
	private String image;
}

