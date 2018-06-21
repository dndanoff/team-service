package com.danoff.common.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.danoff.common.dto.IDto;
import com.danoff.common.model.IEntity;
import com.danoff.common.web.RestPreconditions;

public abstract class AbstractController <D extends IDto, E extends IEntity> extends AbstractReadOnlyController<D, E> {
	
	@Autowired
	public AbstractController(ApplicationEventPublisher eventPublisher) {
		super(eventPublisher);
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.CREATED)
	public D createResources(@RequestBody D dto) {
		LOGGER.debug("Received request to createResources() with params dto={}", dto);
		RestPreconditions.checkRequestElementNotNull(dto);
        RestPreconditions.checkRequestState(dto.getId() == null);
        
        return createResourcesInternal(dto);
	}
	
	protected abstract D createResourcesInternal(D dto);
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public void updateResources(@PathVariable Long id, @RequestBody D dto) {
		LOGGER.debug("Received request to updateResources() with params id={}, dto={}", id, dto);
		RestPreconditions.checkRequestElementNotNull(id);
		RestPreconditions.checkRequestElementNotNull(dto);
        RestPreconditions.checkRequestElementNotNull(dto.getId());
        RestPreconditions.checkRequestState(dto.getId() == id);
        RestPreconditions.checkNotNull(getService().findOne(dto.getId()));
        
        updateResourcesInternal(dto);
	}
	
    protected abstract void updateResourcesInternal(D dto);
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public void deleteResource(@PathVariable Long id) {
		LOGGER.debug("Received request to deleteResource() with params id={}", id);
		RestPreconditions.checkRequestElementNotNull(id);
		RestPreconditions.checkNotNull(getService().findOne(id));
        
		deleteResourceInternal(id);
	}
	
	 protected abstract void deleteResourceInternal(final long id);
}
