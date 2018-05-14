package com.danoff.common.web.exception;

/**
 * Thrown when validation conflict error is found. Message used to describe the validation error.
 */
public class ApiValidationException extends RuntimeException {

    public ApiValidationException(final String message) {
        super(message);
    }

}
