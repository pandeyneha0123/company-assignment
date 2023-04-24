package com.exception;

public class categoryValueException extends RuntimeException {
    
    public categoryValueException(String message) {
        super(message);
    }
    
    public categoryValueException(String message, Throwable cause) {
        super(message, cause);
    }
}


