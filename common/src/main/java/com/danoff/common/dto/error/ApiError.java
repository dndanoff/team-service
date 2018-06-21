package com.danoff.common.dto.error;

import org.springframework.http.HttpStatus;

public class ApiError {

	private final HttpStatus status;
	private final String message;
	private final String errorInfo;
	private final ValidationError valdiationError;

	public ApiError(HttpStatus status, String message) {
		this(status, message, null, null);
	}
	
	public ApiError(HttpStatus status, String message, ValidationError valdiationError) {
		this(status, message, null, valdiationError);
	}

	public ApiError(HttpStatus status, String message, String error) {
		this(status, message, error, null);
	}

	public ApiError(HttpStatus status, String message, String errorInfo, ValidationError valdiationError) {
		super();
		this.status = status;
		this.message = message;
		this.errorInfo = errorInfo;
		this.valdiationError = valdiationError;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public String getErrorInfo() {
		return errorInfo;
	}

	public ValidationError getValdiationError() {
		return valdiationError;
	}
}
