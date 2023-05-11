package com.github.gossie.validation.books.core;

import java.util.Map;

public class BookValidationException extends RuntimeException {

    private final Map<String, String> fieldErrors;

    public BookValidationException(String message, Map<String, String> fieldErrors) {
        super(message);
        this.fieldErrors = fieldErrors;
    }

    public Map<String, String> getFieldErrors() {
        return fieldErrors;
    }
}
