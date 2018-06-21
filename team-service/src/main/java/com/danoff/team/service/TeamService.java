package com.danoff.team.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danoff.common.persistence.CrudRepository;
import com.danoff.common.service.AbstractIService;
import com.danoff.team.model.TeamMember;

@Service
public class TeamService extends AbstractIService<TeamMember>{
	
	private final CrudRepository<TeamMember> repository;

	@Autowired
	public TeamService(CrudRepository<TeamMember> repository) {
		this.repository = repository;
	}

	@Override
	protected CrudRepository<TeamMember> getRepository() {
		return repository;
	}
}
