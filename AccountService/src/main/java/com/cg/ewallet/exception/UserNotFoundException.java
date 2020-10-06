package com.cg.ewallet.exception;

public class UserNotFoundException  extends Exception {


	private static final long serialVersionUID = 1L;

	
	//This exception will be thrown if user with certain mobile number doesnot exist.
	public UserNotFoundException(String message) {
		super(message);
		}
	
	  

}
