package com.cg.ewallet.exception;

public class NoAccountExistException extends Exception{
	
	public NoAccountExistException() {}
	public NoAccountExistException(String message)
	{
		super(message);
	}

}
