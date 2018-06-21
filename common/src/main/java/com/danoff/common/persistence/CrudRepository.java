package com.danoff.common.persistence;

import java.util.List;

import com.danoff.common.model.IEntity;

public interface CrudRepository<E extends IEntity>{
	public long count();
	public E findById(long id);
	public List<E> findPaginated(int page, int size);
	public E create(E entity);
	public void update(E entity);
	public void delete(long id);
}
