package com.example.MsscBrewery.MsscBrewery.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MvcExceptionHandler {
    @SuppressWarnings("rawtypes")
	@ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List> validationErrorHandler(ConstraintViolationException e){
    	List<String> errors = new ArrayList<String>();	
    	e.getConstraintViolations().forEach( er -> {
    		String s = er.getPropertyPath() + ":" + er.getMessage();
    		errors.add(s);
    	});
    	return new ResponseEntity<List>(errors,HttpStatus.BAD_REQUEST);

    }
}
