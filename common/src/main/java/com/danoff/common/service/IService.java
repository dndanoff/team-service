package com.danoff.common.service;

import java.util.List;

import com.danoff.common.model.IEntity;

public interface IService <E extends IEntity> {

	    // find - one

	    E findOne(final long id);

	    // find - paginated
	    /**
	     * - contract: if nothing is found, an empty list will be returned to the calling client <br>
	     */
	    List<E> findAllPaginated(final int page, final int size);

	    // create

	    E create(final E resource);

	    // update

	    void update(final E resource);

	    // delete

	    void delete(final long id);

	    // count

	    long count();
}
