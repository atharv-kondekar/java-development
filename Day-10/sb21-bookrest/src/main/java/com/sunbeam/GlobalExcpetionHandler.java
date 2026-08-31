package com.sunbeam;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExcpetionHandler {
	@ExceptionHandler
	public ResponseEntity<Map<String, String>> handleValidationExcpetion(MethodArgumentNotValidException ex) {
		BindingResult res = ex.getBindingResult();
		Map<String, String> errors = new HashMap<>();
        res.getFieldErrors()
           .forEach(error ->
           		errors.put(error.getField(), error.getDefaultMessage())
           );
        return ResponseEntity.badRequest().body(errors);
	}
}
