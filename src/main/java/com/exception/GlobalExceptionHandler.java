package com.exception;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // Global exception handler for all controllers
public class GlobalExceptionHandler {

	// Handles exceptions for when a blog is not found
	@ExceptionHandler(BlogNotFoundException.class)
	public ResponseEntity<Object> handleValidationExceptions(BlogNotFoundException ex) {
		List<String> details = new ArrayList<>();
		details.add(ex.getMessage());
		return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
	}

	// Handles exceptions for when a comment is not found
	@ExceptionHandler(CommentNotFoundException.class)
	public ResponseEntity<Object> handleValidationExceptions(CommentNotFoundException ex) {
		List<String> details = new ArrayList<>();
		details.add(ex.getMessage());
		return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
	}

	// Handles validation exceptions for invalid method arguments
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}

	// Handles custom exceptions defined in the application
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<Object> handleCustomException(CustomException ex) {
		List<String> details = new ArrayList<>();
		details.add(ex.getMessage());
		return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
	}

}