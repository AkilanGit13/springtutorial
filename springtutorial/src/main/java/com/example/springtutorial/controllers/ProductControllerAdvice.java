package com.example.springtutorial.controllers;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.springtutorial.dtos.ExceptionDTO;
import com.example.springtutorial.exceptions.InvalidProductIdException;

@ControllerAdvice
public class ProductControllerAdvice {
	
	@ExceptionHandler(InvalidProductIdException.class)
	public ResponseEntity<ExceptionDTO> invalidProductIdHandler(InvalidProductIdException e) {
		ExceptionDTO exceptionDTO = new ExceptionDTO(e.getMessage(), "there is no product with id : "+e.getProductId());
		return new ResponseEntity<>(exceptionDTO, HttpStatus.NOT_FOUND);
	}

}
