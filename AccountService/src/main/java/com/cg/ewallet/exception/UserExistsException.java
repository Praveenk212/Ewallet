package com.cg.ewallet.exception;

public class UserExistsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1904585489531578456L;

	//This exception will be thrown if user with certain mobile number exist.
	public UserExistsException(String message) {

		super(message);
	}

	
	
}
