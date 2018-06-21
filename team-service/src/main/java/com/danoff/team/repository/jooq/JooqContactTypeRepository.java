package com.danoff.team.repository.jooq;

import java.util.Collections;
import java.util.List;

import org.jooq.DSLContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.danoff.common.persistence.CrudRepository;
import com.danoff.team.db.Tables;
import com.danoff.team.model.ContactType;

@Repository
public class JooqContactTypeRepository implements CrudRepository<ContactType> {

	private final static Logger LOGGER = LoggerFactory.getLogger(JooqContactTypeRepository.class);

	private final DSLContext create;

	@Autowired
	public JooqContactTypeRepository(DSLContext dsl) {
		this.create = dsl;
	}
	
	@Override
	public long count() {
		LOGGER.debug("Calling count()");
		int result = create.fetchCount(create.selectFrom(Tables.CONTACT_TYPE));
		LOGGER.debug("Calling count() fetched={}", result);
		return result;
	}

	@Override
	public ContactType findById(long id) {
		LOGGER.debug("Calling findMember() with params: id={}", id);
		if(id < 0) {
			LOGGER.debug("Skipping findMember()");
			return null;
		}
		
		ContactType record = create.fetchOne(Tables.CONTACT_TYPE, Tables.CONTACT_TYPE.ID.eq(id)).into(ContactType.class);
		LOGGER.debug("Calling findMember() fetched={}", record);
		return record;
	}

	public List<ContactType> findAll() {
		LOGGER.debug("Calling findAll()");
		List<ContactType> result = create.selectFrom(Tables.CONTACT_TYPE).fetch().into(ContactType.class);
		LOGGER.debug("Calling findAll() fetched={}", result);
		return result;
	}

	@Override
	public List<ContactType> findPaginated(int page, int size) {
		LOGGER.debug("Calling findPaginated() with params: page={}, size={}", page, size);
		if(size < 0 || page < 0) {
			LOGGER.debug("Skipping findMember()");
			return Collections.emptyList();
		}
		List<ContactType> result = create.selectFrom(Tables.CONTACT_TYPE).limit(size).offset(page).fetch().into(ContactType.class);
		LOGGER.debug("Calling findPaginated() fetched={}", result);
		return result;
	}

	@Override
	public ContactType create(ContactType entity) {
		LOGGER.debug("Calling create() with params: entity={}", entity);
		if(entity == null) {
			LOGGER.debug("Skipping create()");
			return null;
		}
		
		ContactType record = create.insertInto(Tables.CONTACT_TYPE)
		.set(Tables.CONTACT_TYPE.NAME, entity.getName())
		.set(Tables.CONTACT_TYPE.PRIORITY, entity.getPriority())
		.returning(Tables.CONTACT_TYPE.ID)
		.fetchOne().into(ContactType.class);
		LOGGER.debug("Calling createMember() returned={}", record);
		
		return record;
	}

	@Override
	public void update(ContactType entity) {
		LOGGER.debug("Calling update() with params: entity={}", entity);
		if(entity == null) {
			LOGGER.debug("Skipping update()");
			return;
		}
		
		create.update(Tables.CONTACT_TYPE)
		.set(Tables.CONTACT_TYPE.NAME, entity.getName())
		.set(Tables.CONTACT_TYPE.PRIORITY, entity.getPriority())
		.where(Tables.CONTACT_TYPE.ID.eq(entity.getId())).execute();
	}

	@Override
	public void delete(long id) {
		LOGGER.debug("Calling delete() with params: id={}", id);
		if(id < 0) {
			LOGGER.debug("Skipping delete()");
			return;
		}
		
		create.deleteFrom(Tables.CONTACT_TYPE).where(Tables.CONTACT_TYPE.ID.eq(id)).execute();
	}
}
