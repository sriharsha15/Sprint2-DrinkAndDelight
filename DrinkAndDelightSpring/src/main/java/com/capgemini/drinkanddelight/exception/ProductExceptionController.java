package com.capgemini.drinkanddelight.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductExceptionController {

	@ExceptionHandler(value = ProductOrderIdException.class)
	public ResponseEntity<Object> exceptionHandling (ProductOrderIdException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = PlaceAnOrderException.class)
	public ResponseEntity<Object> exceptionHandling (PlaceAnOrderException exception){
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}	
}
