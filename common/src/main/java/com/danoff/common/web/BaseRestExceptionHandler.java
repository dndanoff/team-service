package com.danoff.common.web;

import javax.persistence.EntityNotFoundException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.InvalidMediaTypeException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.util.InvalidMimeTypeException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.danoff.common.dto.error.ApiError;
import com.danoff.common.dto.error.ValidationError;
import com.danoff.common.persistence.exception.PersistenceEntityNotFoundException;
import com.danoff.common.web.exception.ApiConflictException;
import com.danoff.common.web.exception.ApiResourceNotFoundException;

@ControllerAdvice
public class BaseRestExceptionHandler extends ResponseEntityExceptionHandler {
	
    private static final Logger log = LoggerFactory.getLogger(BaseRestExceptionHandler.class);

    // API

    // 400
    @Override
    protected final ResponseEntity<Object> handleHttpMessageNotReadable(final HttpMessageNotReadableException ex, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
        log.info("Bad Request: {}", ex.getMessage());
        log.debug("Bad Request: ", ex);
        //
        final String message = ex.getMessage() == null ? ex.getClass().getSimpleName() : ex.getLocalizedMessage();
        final ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, message);
        return handleExceptionInternal(ex, apiError, headers, apiError.getStatus(), request);
    }

    @Override
    protected final ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
        log.info("Bad Request: {}", ex.getMessage());
        log.debug("Bad Request: ", ex);
		//
        final ValidationError validationError = new ValidationError();
        for (final FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            final String localizedErrorMessage = fieldError.getDefaultMessage();
            validationError.addFieldError(fieldError.getField(), localizedErrorMessage);
        }
        
        final String message = ex.getMessage() == null ? ex.getClass().getSimpleName() : ex.getLocalizedMessage();
		final ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, message, validationError);
		return handleExceptionInternal(ex, apiError, headers, apiError.getStatus(), request);
    }

    @ExceptionHandler(value = {ConstraintViolationException.class})
    public final ResponseEntity<Object> handleBadConstraintRequest(final ConstraintViolationException ex, final WebRequest request) {
        log.info("Bad Request: {}", ex.getLocalizedMessage());
        log.debug("Bad Request: ", ex);
        //
        final ValidationError validationError = new ValidationError();
        for (final ConstraintViolation<?> violation : ex.getConstraintViolations()) {
            validationError.addFieldError(violation.getRootBeanClass().getName() + " " + violation.getPropertyPath(), violation.getMessage());
        }
		
        final String message = ex.getMessage() == null ? ex.getClass().getSimpleName() : ex.getLocalizedMessage();
		final ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, message, validationError);
        return handleExceptionInternal(ex, apiError, new HttpHeaders(), apiError.getStatus(), request);
    }
    
    @ExceptionHandler(value = {DataIntegrityViolationException.class})
    public final ResponseEntity<Object> handleBadRequest(final RuntimeException ex, final WebRequest request) {
        log.info("Bad Request: {}", ex.getLocalizedMessage());
        log.debug("Bad Request: ", ex);
        //
		
        final String message = ex.getMessage() == null ? ex.getClass().getSimpleName() : ex.getLocalizedMessage();
		final ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, message);
        return handleExceptionInternal(ex, apiError, new HttpHeaders(), apiError.getStatus(), request);
    }

    // 403
    @ExceptionHandler({ AccessDeniedException.class })
    public ResponseEntity<Object> handleEverything(final AccessDeniedException ex, final WebRequest request) {
        logger.error("403 Status Code", ex);
        //
        final String message = ex.getMessage() == null ? ex.getClass().getSimpleName() : ex.getLocalizedMessage();
        final ApiError apiError = new ApiError(HttpStatus.FORBIDDEN, message);
        return handleExceptionInternal(ex, apiError, new HttpHeaders(), apiError.getStatus(), request);
    }

    // 404
    @ExceptionHandler({ EntityNotFoundException.class, PersistenceEntityNotFoundException.class, ApiResourceNotFoundException.class })
    protected ResponseEntity<Object> handleNotFound(final RuntimeException ex, final WebRequest request) {
        log.warn("Not Found: {}", ex.getMessage());
        //
        final String message = ex.getMessage() == null ? ex.getClass().getSimpleName() : ex.getLocalizedMessage();
        final ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, message);
        return handleExceptionInternal(ex, apiError, new HttpHeaders(), apiError.getStatus(), request);
    }

    // 409
    @ExceptionHandler({ InvalidDataAccessApiUsageException.class, DataAccessException.class, ApiConflictException.class })
    protected ResponseEntity<Object> handleConflict(final RuntimeException ex, final WebRequest request) {
        log.warn("Conflict: {}", ex.getMessage());
        //
        final String message = ex.getMessage() == null ? ex.getClass().getSimpleName() : ex.getLocalizedMessage();
        final ApiError apiError = new ApiError(HttpStatus.CONFLICT, message);
        return handleExceptionInternal(ex, apiError, new HttpHeaders(), apiError.getStatus(), request);
    }

    // 415
    @ExceptionHandler({ InvalidMimeTypeException.class, InvalidMediaTypeException.class })
    protected ResponseEntity<Object> handleInvalidMimeTypeException(final IllegalArgumentException ex, final WebRequest request) {
        log.warn("Unsupported Media Type: {}", ex.getMessage());
        //
        final String message = ex.getMessage() == null ? ex.getClass().getSimpleName() : ex.getLocalizedMessage();
        final ApiError apiError = new ApiError(HttpStatus.UNSUPPORTED_MEDIA_TYPE, message);
        return handleExceptionInternal(ex, apiError, new HttpHeaders(), apiError.getStatus(), request);
    }

    // 500

    @ExceptionHandler({ NullPointerException.class, IllegalArgumentException.class, IllegalStateException.class })
    public ResponseEntity<Object> handle500s(final RuntimeException ex, final WebRequest request) {
        logger.error("500 Status Code", ex);
        //
        final String message = ex.getMessage() == null ? ex.getClass().getSimpleName() : ex.getLocalizedMessage();
        final ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, message);

        return handleExceptionInternal(ex, apiError, new HttpHeaders(), apiError.getStatus(), request);
    }

}
