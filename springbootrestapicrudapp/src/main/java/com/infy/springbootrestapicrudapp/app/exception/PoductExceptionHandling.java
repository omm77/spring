package com.infy.springbootrestapicrudapp.app.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PoductExceptionHandling {

	@ExceptionHandler(ProductNotFoundException.class)
	public Map<String ,String> handlingInvalidArguments(ProductNotFoundException ex)
	{
	        Map<String,String> error=new HashMap<>();
	        error.put("errorMessage",ex.getMessage());
		
		return error;
	}
}
