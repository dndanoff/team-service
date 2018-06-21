package com.danoff.common.web.exception;

public final class ApiPreconditionFailedException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -3029559070492115264L;

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
