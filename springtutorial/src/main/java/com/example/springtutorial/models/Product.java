package com.example.springtutorial.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseEntity{
	private String title;
	private Double price;
	@ManyToOne(cascade = CascadeType.ALL)
	private Category category;
	private String description;
	private String image;
}

