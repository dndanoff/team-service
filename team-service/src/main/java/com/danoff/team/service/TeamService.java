package com.danoff.team.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danoff.common.persistence.CrudRepository;
import com.danoff.common.service.AbstractIService;
import com.danoff.team.model.TeamModel;

@Service
public class TeamService extends AbstractIService<TeamModel>{

	private final CrudRepository<TeamModel> repository;
	
	@Autowired
	public TeamService(CrudRepository<TeamModel> repository) {
		this.repository = repository;
	}


	@Override
	protected CrudRepository<TeamModel> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}

}
