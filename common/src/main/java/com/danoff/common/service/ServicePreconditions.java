package com.danoff.common.service;

import com.danoff.common.persistence.exception.PersistenceEntityNotFoundException;

public class ServicePreconditions {
	
    private ServicePreconditions() {
        throw new AssertionError();
    }

    // API

    /**
     * Ensures that the entity reference passed as a parameter to the calling method is not null.
     * 
     * @param entity
     *            an object reference
     * @return the non-null reference that was validated
     * @throws MyEntityNotFoundException
     *             if {@code entity} is null
     */
    public static <T> T checkEntityExists(final T entity) {
        if (entity == null) {
            throw new PersistenceEntityNotFoundException();
        }
        return entity;
    }
    
    public static <T> T checkEntityParameterNotNull(final T entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Entity parameter cannot be null.");
        }
        return entity;
    }
}
