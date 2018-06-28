package com.danoff.team.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danoff.common.persistence.CrudRepository;
import com.danoff.common.service.AbstractIService;
import com.danoff.team.model.TeamMember;

@Service
public class TeamMemberService extends AbstractIService<TeamMember>{
	
	private final CrudRepository<TeamMember> repository;

	@Autowired
	public TeamMemberService(CrudRepository<TeamMember> repository) {
		this.repository = repository;
	}

	@Override
	protected CrudRepository<TeamMember> getRepository() {
		return repository;
	}
}
