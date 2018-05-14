package com.danoff.common.web.exception;

public final class ApiBadRequestException extends RuntimeException {

    public ApiBadRequestException() {
        super();
    }

    public ApiBadRequestException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ApiBadRequestException(final String message) {
        super(message);
    }

    public ApiBadRequestException(final Throwable cause) {
        super(cause);
    }

}
