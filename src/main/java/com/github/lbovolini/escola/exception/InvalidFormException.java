package com.github.lbovolini.escola.exception;

import com.github.lbovolini.escola.message.InputError;

import java.util.List;

public class InvalidFormException extends RuntimeException {

    private final List<InputError> errors;

    public InvalidFormException(List<InputError> errors) {
        this.errors = errors;
    }

    public List<InputError> getErrors() {
        return errors;
    }
}