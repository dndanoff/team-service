package com.danoff.common.web;

import org.springframework.http.HttpStatus;

import com.danoff.common.web.exception.ApiBadRequestException;
import com.danoff.common.web.exception.ApiConflictException;
import com.danoff.common.web.exception.ApiForbiddenException;
import com.danoff.common.web.exception.ApiResourceNotFoundException;

/**
 * Simple static methods to be called at the start of your own methods to verify
 * correct arguments and state. If the Precondition fails, an {@link HttpStatus}
 * code is thrown
 */
public final class RestPreconditions {

    private RestPreconditions() {
        throw new AssertionError();
    }

    // API

    /**
     * Ensures that an object reference passed as a parameter to the calling method is not null.
     *
     * @param reference
     *            an object reference
     *
     * @return the non-null reference that was validated
     *
     * @throws ApiResourceNotFoundException
     *             if {@code reference} is null
     */
    public static <T> T checkNotNull(final T reference) {
        return checkNotNull(reference, null);
    }

    /**
     * Ensures that an object reference passed as a parameter to the calling method is not null.
     *
     * @param reference
     *            an object reference
     * @param message
     *            the message of the exception if the check fails
     *
     * @return the non-null reference that was validated
     *
     * @throws ApiResourceNotFoundException
     *             if {@code reference} is null
     */
    public static <T> T checkNotNull(final T reference, final String message) {
        if (reference == null) {
            throw new ApiResourceNotFoundException(message);
        }
        return reference;
    }

    /**
     * Ensures that an object reference passed as a parameter to the calling
     * method is not null.
     *
     * @param reference
     *            an object reference
     * @return the non-null reference that was validated
     *
     * @throws ApiBadRequestException
     *             if {@code reference} is null
     */
    public static <T> T checkRequestElementNotNull(final T reference) {
        return checkRequestElementNotNull(reference, null);
    }

    /**
     * Ensures that an object reference passed as a parameter to the calling method is not null.
     *
     * @param reference
     *            an object reference
     * @param message
     *            the message of the exception if the check fails
     *
     * @return the non-null reference that was validated
     *
     * @throws ApiBadRequestException
     *             if {@code reference} is null
     */
    public static <T> T checkRequestElementNotNull(final T reference, final String message) {
        if (reference == null) {
            throw new ApiBadRequestException(message);
        }
        return reference;
    }

    /**
     * Ensures the truth of an expression
     *
     * @param expression
     *            a boolean expression
     *
     * @throws ApiConflictException
     *             if {@code expression} is false
     */
    public static void checkRequestState(final boolean expression) {
        checkRequestState(expression, null);
    }

    /**
     * Ensures the truth of an expression
     *
     * @param expression
     *            a boolean expression
     * @param message
     *            the message of the exception if the check fails
     *
     * @throws ApiConflictException
     *             if {@code expression} is false
     */
    public static void checkRequestState(final boolean expression, final String message) {
        if (!expression) {
            throw new ApiConflictException(message);
        }
    }

    /**
     * Ensures the truth of an expression related to the validity of the request
     *
     * @param expression
     *            a boolean expression
     *
     * @throws ApiBadRequestException
     *             if {@code expression} is false
     */
    public static void checkIfBadRequest(final boolean expression) {
        checkIfBadRequest(expression, null);
    }

    /**
     * Ensures the truth of an expression related to the validity of the request
     *
     * @param expression
     *            a boolean expression
     * @param message
     *            the message of the exception if the check fails
     *
     * @throws ApiBadRequestException
     *             if {@code expression} is false
     */
    public static void checkIfBadRequest(final boolean expression, final String message) {
        if (!expression) {
            throw new ApiBadRequestException(message);
        }
    }

    /**
     * Check if some value was found, otherwise throw exception.
     *
     * @param expression
     *            has value true if found, otherwise false
     *
     * @throws ApiResourceNotFoundException
     *             if expression is false, means value not found.
     */
    public static void checkFound(final boolean expression) {
        checkFound(expression, null);
    }

    /**
     * Check if some value was found, otherwise throw exception.
     *
     * @param expression
     *            has value true if found, otherwise false
     * @param message
     *            the message of the exception if the check fails
     *
     * @throws ApiResourceNotFoundException
     *             if expression is false, means value not found.
     */
    public static void checkFound(final boolean expression, final String message) {
        if (!expression) {
            throw new ApiResourceNotFoundException(message);
        }
    }

    /**
     * Check if some value was found, otherwise throw exception.
     *
     * @param expression
     *            has value true if found, otherwise false
     *
     * @throws ApiResourceNotFoundException
     *             if expression is false, means value not found.
     */
    public static <T> T checkFound(final T resource) {
        return checkFound(resource, null);
    }

    /**
     * Check if some value was found, otherwise throw exception.
     *
     * @param expression
     *            has value true if found, otherwise false
     * @param message
     *            the message of the exception if the check fails
     *
     * @throws ApiResourceNotFoundException
     *             if expression is false, means value not found.
     */
    public static <T> T checkFound(final T resource, final String message) {
        if (resource == null) {
            throw new ApiResourceNotFoundException(message);
        }

        return resource;
    }

    /**
     * Check if some value was found, otherwise throw exception.
     *
     * @param expression
     *            has value true if found, otherwise false
     *
     * @throws ApiForbiddenException
     *             if expression is false, means operation not allowed.
     */
    public static void checkAllowed(final boolean expression) {
        checkAllowed(expression, null);
    }

    /**
     * Check if some value was found, otherwise throw exception.
     *
     * @param expression
     *            has value true if found, otherwise false
     * @param message
     *            the message of the exception if the check fails
     *
     * @throws ApiForbiddenException
     *             if expression is false, means operation not allowed.
     */
    public static void checkAllowed(final boolean expression, final String message) {
        if (!expression) {
            throw new ApiForbiddenException(message);
        }
    }

}
