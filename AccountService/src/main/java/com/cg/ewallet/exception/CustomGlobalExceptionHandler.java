package com.cg.ewallet.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

//	private final HttpStatus status = null;
//
//	private final String reason = "";
//	
//	public static ResponseEntity<Object> ResponseStatusException(HttpStatus status, @Nullable String reason) {
//		CustomErrorDetails custErrorDetail=new CustomErrorDetails(new Date(),reason,reason);
//		return new ResponseEntity<Object>(custErrorDetail,HttpStatus.BAD_REQUEST);
//	}
//	
}
