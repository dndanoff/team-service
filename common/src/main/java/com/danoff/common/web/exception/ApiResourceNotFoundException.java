package com.danoff.common.web.exception;

public final class ApiResourceNotFoundException extends RuntimeException {

    public ApiResourceNotFoundException() {
        super();
    }

    public ApiResourceNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ApiResourceNotFoundException(final String message) {
        super(message);
    }

    public ApiResourceNotFoundException(final Throwable cause) {
        super(cause);
    }

}
