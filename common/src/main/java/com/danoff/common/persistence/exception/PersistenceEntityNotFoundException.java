package com.danoff.common.persistence.exception;

public final class PersistenceEntityNotFoundException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -5705844195655027746L;

	public PersistenceEntityNotFoundException() {
        super();
    }

    public PersistenceEntityNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public PersistenceEntityNotFoundException(final String message) {
        super(message);
    }

    public PersistenceEntityNotFoundException(final Throwable cause) {
        super(cause);
    }

}
