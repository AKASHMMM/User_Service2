package com.example.Exceptions;


@SuppressWarnings("serial")
public class UserNotFoundException extends RuntimeException {
	
    public UserNotFoundException() {
    }

    public UserNotFoundException(String message) {
        super(message);
    }

}