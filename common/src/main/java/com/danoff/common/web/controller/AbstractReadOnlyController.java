package com.danoff.common.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.danoff.common.dto.IDto;
import com.danoff.common.dto.views.DtoView;
import com.danoff.common.model.IEntity;
import com.danoff.common.service.IService;
import com.danoff.common.web.RestPreconditions;
import com.fasterxml.jackson.annotation.JsonView;

public abstract class AbstractReadOnlyController <D extends IDto, E extends IEntity> {
	
    protected final Logger LOGGER = LoggerFactory.getLogger(getClass());

    
    protected final ApplicationEventPublisher eventPublisher;

    @Autowired
    public AbstractReadOnlyController(ApplicationEventPublisher eventPublisher) {
        super();
        this.eventPublisher = eventPublisher;
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/count")
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public long countResources() {
    	LOGGER.debug("Received request to countResources() resources");
        return countResourcesInternal();
    }
    
    protected long countResourcesInternal() {
        return getService().count();
    }
    
    @JsonView(DtoView.Aggregated.class)
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
	public List<D> findResourcesPaginated(
			@RequestParam(name = "pageNumber", defaultValue = "0", required = false) int page,
			@RequestParam(name = "pageSize", defaultValue = "25", required = false) int size) {
    	LOGGER.debug("Received request to findResourcesPaginated() with params page={}, size={}", page, size);
		return findResourcesPaginatedInternal(page, size);
	}
	
    protected abstract List<D> findResourcesPaginatedInternal(int page, int size) ;
    
    @JsonView(DtoView.Detailed.class)
    @RequestMapping(value="/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public D findOneResource(@PathVariable final Long id) {
    	LOGGER.debug("Received request to findOneResource() with params id={}", id);
    	RestPreconditions.checkRequestElementNotNull(id);
    	return RestPreconditions.checkNotNull(findOneResourceInternal(id));
    }

    protected abstract D findOneResourceInternal(final Long id) ;
    
    protected abstract IService<E> getService();
}
