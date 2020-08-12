package com.github.lbovolini.escola.message;

public class InputError {

    private final String field;
    private final String error;

    public InputError(String field, String error) {
        this.field = field;
        this.error = error;
    }

    public String getField() {
        return field;
    }

    public String getError() {
        return error;
    }
}
