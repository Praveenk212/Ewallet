package com.cg.ewallet.entity;

public class CustomErrorDetails {
	
	private String message;
	private String errorDetails;
	public CustomErrorDetails(String errorDetails, String message ) {
		super();
		this.message = message;
		this.errorDetails = errorDetails;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getErrorDetails() {
		return errorDetails;
	}
	public void setErrorDetails(String errorDetails) {
		this.errorDetails = errorDetails;
	}
	

}
