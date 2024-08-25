package com.example.springtutorial.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Category extends BaseEntity {
	private String category;
	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
	private List<Product> products;
}
