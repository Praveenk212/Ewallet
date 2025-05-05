package com.cg.ewallet.exception;

public class NoPendingAccount extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoPendingAccount(String message) {
		//is used to throw this exception if there is no pending account
		super(message);
	}
	

}
