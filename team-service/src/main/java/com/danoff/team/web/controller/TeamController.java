package com.danoff.team.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danoff.common.service.IService;
import com.danoff.common.web.controller.AbstractController;
import com.danoff.team.dto.TeamDto;
import com.danoff.team.mapper.TeamMapper;
import com.danoff.team.model.TeamModel;

@RestController
@RequestMapping(value = "/teams")
@CrossOrigin(origins = "http://localhost:3000")
public class TeamController extends AbstractController<TeamDto, TeamModel>{

	
	private final IService<TeamModel> service;
	private final TeamMapper mapper;

	@Autowired
	public TeamController(ApplicationEventPublisher eventPublisher, IService<TeamModel> service, TeamMapper mapper) {
		super(eventPublisher);
		this.service = service;
		this.mapper = mapper;
	}

	@Override
	protected TeamDto createResourcesInternal(TeamDto dto) {
		TeamModel entity = mapper.dtoToEntity(dto);
		entity = getService().create(entity);
		
		return mapper.entityToDto(entity);
	}

	@Override
	protected void updateResourcesInternal(TeamDto dto) {
		TeamModel entity = mapper.dtoToEntity(dto);
		getService().update(entity);
		
	}

	@Override
	protected void deleteResourceInternal(long id) {
		getService().delete(id);
		
	}

	@Override
	protected List<TeamDto> findResourcesPaginatedInternal(int page, int size) {
		List<TeamModel> entities = getService().findAllPaginated(page, size);
		System.out.println("---->" + entities.get(0));
		return mapper.entityToDto(entities);
	}

	@Override
	protected TeamDto findOneResourceInternal(Long id) {
		TeamModel entity = getService().findOne(id);
		return mapper.entityToDto(entity);
	}

	@Override
	protected IService<TeamModel> getService() {
		return service;
	}

}
