package com.danoff.common.persistence.exception;

public final class ApiEntityNotFoundException extends RuntimeException {

    public ApiEntityNotFoundException() {
        super();
    }

    public ApiEntityNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ApiEntityNotFoundException(final String message) {
        super(message);
    }

    public ApiEntityNotFoundException(final Throwable cause) {
        super(cause);
    }

}
