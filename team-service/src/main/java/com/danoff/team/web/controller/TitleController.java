package com.danoff.team.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danoff.common.service.IService;
import com.danoff.common.web.controller.AbstractController;
import com.danoff.team.dto.TitleDto;
import com.danoff.team.mapper.TitleMapper;
import com.danoff.team.model.Title;

@RestController
@RequestMapping(value = "/titles")
public class TitleController extends AbstractController<TitleDto, Title>{

	private final IService<Title> service;
	private final TitleMapper mapper;

	@Autowired
	public TitleController(ApplicationEventPublisher eventPublisher, IService<Title> service, TitleMapper mapper) {
		super(eventPublisher);
		this.service = service;
		this.mapper = mapper;
	}

	@Override
	protected IService<Title> getService() {
		return service;
	}

	@Override
	protected TitleDto createResourcesInternal(TitleDto dto) {
		Title entity = mapper.dtoToEntity(dto);
		entity = getService().create(entity);
		
		return mapper.entityToDto(entity);
	}


	@Override
	protected void updateResourcesInternal(TitleDto dto) {
		Title entity = mapper.dtoToEntity(dto);
		getService().update(entity);
	}

	@Override
	protected void deleteResourceInternal(long id) {
		getService().delete(id);
	}

	@Override
	protected List<TitleDto> findResourcesPaginatedInternal(int page, int size) {
		List<Title> entities = getService().findAllPaginated(page, size);
		
		return mapper.entityToDto(entities);
	}

	@Override
	protected TitleDto findOneResourceInternal(Long id) {
		Title entity = getService().findOne(id);
		return mapper.entityToDto(entity);
	}
}
