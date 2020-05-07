package com.capgemini.drinkanddelight.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductStockExceptionController 
{
	@ExceptionHandler(value = ProductStockException.class)
	public ResponseEntity<Object> handleException(ProductStockException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}

}
