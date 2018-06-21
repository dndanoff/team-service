package com.danoff.team.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danoff.common.persistence.CrudRepository;
import com.danoff.common.service.AbstractIService;
import com.danoff.team.model.Title;

@Service
public class TitleService extends AbstractIService<Title>{
	
	private final CrudRepository<Title> repository;

	@Autowired
	public TitleService(CrudRepository<Title> repository) {
		this.repository = repository;
	}

	@Override
	protected CrudRepository<Title> getRepository() {
		return repository;
	}
}
