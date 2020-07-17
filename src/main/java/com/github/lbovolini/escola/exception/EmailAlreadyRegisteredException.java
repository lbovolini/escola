package com.github.lbovolini.escola.exception;

public class EmailAlreadyRegisteredException extends RuntimeException {

    private static final String message = "Email already registered";

    public EmailAlreadyRegisteredException() {
        super(message);
    }
}
