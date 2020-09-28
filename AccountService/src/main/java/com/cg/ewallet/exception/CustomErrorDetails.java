package com.cg.ewallet.exception;

import java.util.Date;

public class CustomErrorDetails {
	
	private Date timeStamp;
	private String message;
	private String errorDetails;
	public CustomErrorDetails(Date timeStamp, String message, String errorDetails) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.errorDetails = errorDetails;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
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
