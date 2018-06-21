package com.danoff.team.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danoff.common.persistence.CrudRepository;
import com.danoff.common.service.AbstractIService;
import com.danoff.team.model.ContactType;

@Service
public class ContactTypeService extends AbstractIService<ContactType>{
	
	private final CrudRepository<ContactType> repository;

	@Autowired
	public ContactTypeService(CrudRepository<ContactType> repository) {
		this.repository = repository;
	}

	@Override
	protected CrudRepository<ContactType> getRepository() {
		return repository;
	}
}
