package com.cjc.app.exception;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandling {

	@ExceptionHandler(value = IOException.class)
	public ResponseEntity<String> documentNotFoundException(IOException ae){
		String msg=ae.getMessage();
		
		return new ResponseEntity<String>(msg,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
