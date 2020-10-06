package com.cg.ewallet.dto;



public class Message {
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}

	String message;

	public Message(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Message [message=" + message + "]";
	}

}
