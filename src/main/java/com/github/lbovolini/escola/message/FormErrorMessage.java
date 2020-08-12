package com.github.lbovolini.escola.message;

import java.util.List;

public class FormErrorMessage {

    private final List<InputError> errors;

    public FormErrorMessage(List<InputError> errors) {
        this.errors = errors;
    }

    public List<InputError> getErrors() {
        return errors;
    }
}
