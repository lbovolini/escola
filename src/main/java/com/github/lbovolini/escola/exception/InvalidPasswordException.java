package com.github.lbovolini.escola.exception;

public class InvalidPasswordException extends RuntimeException {

    private static final String message = "Invalid user password";

    public InvalidPasswordException() {
        super(message);
    }
}
