package com.example.Exceptions;


@SuppressWarnings("serial")
public class UserAlreadyExistsException extends RuntimeException {
	
    public UserAlreadyExistsException() {
    }

    public UserAlreadyExistsException(String message) {
        super(message);
    }

}