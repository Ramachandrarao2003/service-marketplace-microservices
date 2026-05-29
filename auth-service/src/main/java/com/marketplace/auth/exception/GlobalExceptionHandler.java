package com.marketplace.auth.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<Map<String, Object>>handleRuntimeException(RuntimeException ex){
		
		Map<String, Object> error=new HashMap<String, Object>();
		
		error.put("Timestamp", LocalDateTime.now());
		
		error.put("status", 401);
		
		error.put("error", ex.getMessage());
		
		 return new ResponseEntity<>(
	                error,
	                HttpStatus.UNAUTHORIZED
	        );
	}

}
