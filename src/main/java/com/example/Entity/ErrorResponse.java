package com.example.Entity;

public class ErrorResponse {
	
	private String message;
	@Override
	public String toString() {
		return "ErrorResponse [message=" + message + ", getMessage()=" + getMessage() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	public ErrorResponse() {
		super();
	}

	public ErrorResponse(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	


}

