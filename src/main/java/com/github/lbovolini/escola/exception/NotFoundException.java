package com.github.lbovolini.escola.exception;

public class NotFoundException extends RuntimeException {

    private static final String message = "Not found";

    public NotFoundException() {
        super(message);
    }
}
