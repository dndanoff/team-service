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
import com.danoff.team.model.Title;

@Repository
public class JooqTitleRepository implements CrudRepository<Title> {

	private final static Logger LOGGER = LoggerFactory.getLogger(JooqTitleRepository.class);

	private final DSLContext create;

	@Autowired
	public JooqTitleRepository(DSLContext dsl) {
		this.create = dsl;
	}
	
	@Override
	public long count() {
		LOGGER.debug("Calling count()");
		int result = create.fetchCount(create.selectFrom(Tables.TITLE));
		LOGGER.debug("Calling count() fetched={}", result);
		return result;
	}

	@Override
	public Title findById(long id) {
		LOGGER.debug("Calling findMember() with params: id={}", id);
		if(id < 0) {
			LOGGER.debug("Skipping findMember()");
			return null;
		}
		
		Title record = create.fetchOne(Tables.TITLE, Tables.TITLE.ID.eq(id)).into(Title.class);
		LOGGER.debug("Calling findMember() fetched={}", record);
		return record;
	}

	public List<Title> findAll() {
		LOGGER.debug("Calling findAll()");
		List<Title> result = create.selectFrom(Tables.TITLE).fetch().into(Title.class);
		LOGGER.debug("Calling findAll() fetched={}", result);
		return result;
	}

	@Override
	public List<Title> findPaginated(int page, int size) {
		LOGGER.debug("Calling findPaginated() with params: page={}, size={}", page, size);
		if(size < 0 || page < 0) {
			LOGGER.debug("Skipping findMember()");
			return Collections.emptyList();
		}
		List<Title> result = create.selectFrom(Tables.TITLE).limit(size).offset(page).fetch().into(Title.class);
		LOGGER.debug("Calling findPaginated() fetched={}", result);
		return result;
	}

	@Override
	public Title create(Title entity) {
		LOGGER.debug("Calling create() with params: entity={}", entity);
		if(entity == null) {
			LOGGER.debug("Skipping create()");
			return null;
		}
		
		Title record = create.insertInto(Tables.TITLE)
		.set(Tables.TITLE.NAME, entity.getName())
		.set(Tables.TITLE.DESCRIPTION, entity.getDescription())
		.returning(Tables.TITLE.ID)
		.fetchOne().into(Title.class);
		LOGGER.debug("Calling createMember() returned={}", record);
		
		return record;
	}

	@Override
	public void update(Title entity) {
		LOGGER.debug("Calling update() with params: entity={}", entity);
		if(entity == null) {
			LOGGER.debug("Skipping update()");
			return;
		}
		
		create.update(Tables.TITLE)
		.set(Tables.TITLE.NAME, entity.getName())
		.set(Tables.TITLE.DESCRIPTION, entity.getDescription())
		.where(Tables.TITLE.ID.eq(entity.getId())).execute();
	}

	@Override
	public void delete(long id) {
		LOGGER.debug("Calling delete() with params: id={}", id);
		if(id < 0) {
			LOGGER.debug("Skipping delete()");
			return;
		}
		
		create.deleteFrom(Tables.TITLE).where(Tables.TITLE.ID.eq(id)).execute();
	}
}
