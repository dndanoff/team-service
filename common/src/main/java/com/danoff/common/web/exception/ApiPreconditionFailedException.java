package com.danoff.common.web.exception;

public final class ApiPreconditionFailedException extends RuntimeException {

    public ApiPreconditionFailedException() {
        super();
    }

    public ApiPreconditionFailedException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ApiPreconditionFailedException(final String message) {
        super(message);
    }

    public ApiPreconditionFailedException(final Throwable cause) {
        super(cause);
    }

}
