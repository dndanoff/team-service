package com.danoff.team.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danoff.common.service.IService;
import com.danoff.common.web.controller.AbstractController;
import com.danoff.team.dto.ContactTypeDto;
import com.danoff.team.mapper.ContactTypeMapper;
import com.danoff.team.model.ContactType;

@RestController
@RequestMapping(value = "/contact-types")
public class ContactTypeController extends AbstractController<ContactTypeDto, ContactType>{

	private final IService<ContactType> service;
	private final ContactTypeMapper mapper;

	@Autowired
	public ContactTypeController(ApplicationEventPublisher eventPublisher, IService<ContactType> service, ContactTypeMapper mapper) {
		super(eventPublisher);
		this.service = service;
		this.mapper = mapper;
	}

	@Override
	protected IService<ContactType> getService() {
		return service;
	}

	@Override
	protected ContactTypeDto createResourcesInternal(ContactTypeDto dto) {
		ContactType entity = mapper.dtoToEntity(dto);
		entity = getService().create(entity);
		
		return mapper.entityToDto(entity);
	}


	@Override
	protected void updateResourcesInternal(ContactTypeDto dto) {
		ContactType entity = mapper.dtoToEntity(dto);
		getService().update(entity);
	}

	@Override
	protected void deleteResourceInternal(long id) {
		getService().delete(id);
	}

	@Override
	protected List<ContactTypeDto> findResourcesPaginatedInternal(int page, int size) {
		List<ContactType> entities = getService().findAllPaginated(page, size);
		
		return mapper.entityToDto(entities);
	}

	@Override
	protected ContactTypeDto findOneResourceInternal(Long id) {
		ContactType entity = getService().findOne(id);
		return mapper.entityToDto(entity);
	}
}
