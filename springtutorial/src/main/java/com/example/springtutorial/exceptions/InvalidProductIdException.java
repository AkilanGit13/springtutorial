package com.example.springtutorial.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvalidProductIdException extends Exception{
	private Long productId;
	
	public InvalidProductIdException(Long productId, String msg) {
		super(msg);
		this.productId = productId;
	}
}
