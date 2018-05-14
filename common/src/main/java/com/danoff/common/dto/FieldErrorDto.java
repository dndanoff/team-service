package com.danoff.common.dto;

public class FieldErrorDto {

    private final String field;

    private final String message;

    public FieldErrorDto(final String field, final String message) {
        this.field = field;
        this.message = message;
    }

    // API

    public String getField() {
        return field;
    }

    public String getMessage() {
        return message;
    }

}