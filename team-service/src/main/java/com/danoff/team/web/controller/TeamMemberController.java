package com.danoff.team.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danoff.common.service.IService;
import com.danoff.common.web.controller.AbstractController;
import com.danoff.team.dto.TeamMemberDto;
import com.danoff.team.mapper.TeamMemberMapper;
import com.danoff.team.model.TeamMember;

@RestController
@RequestMapping(value = "/members")
public class TeamMemberController extends AbstractController<TeamMemberDto, TeamMember>{

	private final IService<TeamMember> service;
	private final TeamMemberMapper mapper;

	@Autowired
	public TeamMemberController(ApplicationEventPublisher eventPublisher, IService<TeamMember> service, TeamMemberMapper mapper) {
		super(eventPublisher);
		this.service = service;
		this.mapper = mapper;
	}

	@Override
	protected IService<TeamMember> getService() {
		return service;
	}

	@Override
	protected TeamMemberDto createResourcesInternal(TeamMemberDto dto) {
		TeamMember entity = mapper.dtoToEntity(dto);
		entity = getService().create(entity);
		
		return mapper.entityToDto(entity);
	}


	@Override
	protected void updateResourcesInternal(TeamMemberDto dto) {
		TeamMember entity = mapper.dtoToEntity(dto);
		getService().update(entity);
	}

	@Override
	protected void deleteResourceInternal(long id) {
		getService().delete(id);
	}

	@Override
	protected List<TeamMemberDto> findResourcesPaginatedInternal(int page, int size) {
		List<TeamMember> entities = getService().findAllPaginated(page, size);
		
		return mapper.entityToDto(entities);
	}

	@Override
	protected TeamMemberDto findOneResourceInternal(Long id) {
		TeamMember entity = getService().findOne(id);
		return mapper.entityToDto(entity);
	}
}
