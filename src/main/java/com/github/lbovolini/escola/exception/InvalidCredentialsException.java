package com.github.lbovolini.escola.exception;

public class InvalidCredentialsException extends RuntimeException {

    private static final String message = "Invalid user credentials";

    public InvalidCredentialsException() {
        super(message);
    }
}
