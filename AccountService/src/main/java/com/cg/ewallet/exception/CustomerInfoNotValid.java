package com.cg.ewallet.exception;

public class CustomerInfoNotValid  extends Exception {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//This exception will be thrown if user information is not correct.
	public CustomerInfoNotValid(String message) {
		super(message);
		}
	
	

}
