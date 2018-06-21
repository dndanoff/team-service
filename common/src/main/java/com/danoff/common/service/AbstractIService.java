package com.danoff.common.service;

import java.util.Collections;
import java.util.List;

import com.danoff.common.model.IEntity;
import com.danoff.common.persistence.CrudRepository;

public abstract class AbstractIService<E extends IEntity> implements IService<E>{

	// find
	public E findOne(long id) {
		return getRepository().findById(id);
	}

	public List<E> findAllPaginated(int page, int size) {
		final List<E> content = getRepository().findPaginated(page, size);
        if (content == null) {
            return Collections.emptyList();
        }
        return content;
	}

	// save/create/persist
	public E create(E resource) {
		ServicePreconditions.checkEntityParameterNotNull(resource);
        E persistedEntity = getRepository().create(resource);

        return persistedEntity;
	}

	// update/merge
	public void update(E resource) {
		ServicePreconditions.checkEntityParameterNotNull(resource);
        getRepository().update(resource);
		
	}

	// delete
	public void delete(long id) {
		final E entity = getRepository().findById(id);
        ServicePreconditions.checkEntityExists(entity);
        getRepository().delete(id);
		
	}

	// count
	public long count() {
		return getRepository().count();
	}

    protected abstract CrudRepository<E> getRepository();
}
