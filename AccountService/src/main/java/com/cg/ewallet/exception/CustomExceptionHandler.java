package com.cg.ewallet.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.ewallet.dto.CustomErrorDetails;

@ControllerAdvice
public class CustomExceptionHandler  {

	
	//This Method is used to customize the exception.
	@ExceptionHandler({UserNotFoundException.class, NoPendingAccount.class})
	public ResponseEntity<CustomErrorDetails> mapException(Exception exc)
	{
		CustomErrorDetails customError=new CustomErrorDetails(HttpStatus.NOT_FOUND.toString(),exc.getMessage());
		return new ResponseEntity<>(customError,HttpStatus.NOT_FOUND);
	}
	

	
}
