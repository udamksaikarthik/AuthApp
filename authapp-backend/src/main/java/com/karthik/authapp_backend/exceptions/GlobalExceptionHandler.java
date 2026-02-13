package com.karthik.authapp_backend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.karthik.authapp_backend.dtos.ErrorResponse;


@RestControllerAdvice
public class GlobalExceptionHandler {

	//resource not found exception handler :: method
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException exception){
		ErrorResponse internalServerError = new ErrorResponse(exception.getMessage(), HttpStatus.NOT_FOUND, 404);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(internalServerError);
		
	}
	
	//Illegal argument exception handler :: method
		@ExceptionHandler(IllegalArgumentException.class)
		public ResponseEntity<ErrorResponse> illegalArgumentExceptionHandler(IllegalArgumentException exception){
			ErrorResponse internalServerError = new ErrorResponse(exception.getMessage(), HttpStatus.BAD_REQUEST, 400);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(internalServerError);
			
		}
}
