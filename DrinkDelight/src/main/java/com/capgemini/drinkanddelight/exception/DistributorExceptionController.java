package com.capgemini.drinkanddelight.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DistributorExceptionController 
{
	@ExceptionHandler(value = DistributorException.class)
	public ResponseEntity<Object> handleException(DistributorException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}

	
}
