package com.myapp.domain.exceptions;

public class ExampleCustomException extends RuntimeException{

    private String message;

    public ExampleCustomException(String message) {
        super(message);
    }
}
