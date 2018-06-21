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
import com.danoff.team.db.tables.Member;
import com.danoff.team.model.TeamMember;

@Repository
public class JooqTeamMemberRepository implements CrudRepository<TeamMember> {

	private final static Logger LOGGER = LoggerFactory.getLogger(JooqTeamMemberRepository.class);

	private final DSLContext create;

	@Autowired
	public JooqTeamMemberRepository(DSLContext dsl) {
		this.create = dsl;
	}
	
	@Override
	public long count() {
		LOGGER.debug("Calling count()");
		int result = create.fetchCount(create.selectFrom(Tables.MEMBER));
		LOGGER.debug("Calling count() fetched={}", result);
		return result;
	}

	@Override
	public TeamMember findById(long id) {
		LOGGER.debug("Calling findMember() with params: id={}", id);
		if(id < 0) {
			LOGGER.debug("Skipping findMember()");
			return null;
		}
		
		TeamMember record = create.fetchOne(Tables.MEMBER, Member.MEMBER.ID.eq(id)).into(TeamMember.class);
		LOGGER.debug("Calling findMember() fetched={}", record);
		return record;
	}

	public List<TeamMember> findAll() {
		LOGGER.debug("Calling findAll()");
		List<TeamMember> result = create.selectFrom(Tables.MEMBER).fetch().into(TeamMember.class);
		LOGGER.debug("Calling findAll() fetched={}", result);
		return result;
	}

	@Override
	public List<TeamMember> findPaginated(int page, int size) {
		LOGGER.debug("Calling findPaginated() with params: page={}, size={}", page, size);
		if(size < 0 || page < 0) {
			LOGGER.debug("Skipping findMember()");
			return Collections.emptyList();
		}
		List<TeamMember> result = create.selectFrom(Tables.MEMBER).limit(size).offset(page).fetch().into(TeamMember.class);
		LOGGER.debug("Calling findPaginated() fetched={}", result);
		return result;
	}

	@Override
	public TeamMember create(TeamMember member) {
		LOGGER.debug("Calling createMember() with params: member={}", member);
		if(member == null) {
			LOGGER.debug("Skipping create()");
			return null;
		}
		
		TeamMember record = create.insertInto(Tables.MEMBER)
		.set(Tables.MEMBER.FIRST_NAME, member.getFirstName())
		.set(Tables.MEMBER.LAST_NAME, member.getLastName())
		.set(Tables.MEMBER.HIRE_DATE, member.getHireDate())
		.set(Tables.MEMBER.PHOTO_URL, member.getPhotoUrl())
		.returning(Tables.MEMBER.ID)
		.fetchOne().into(TeamMember.class);
		LOGGER.debug("Calling createMember() returned={}", record);
		
		return record;
	}

	@Override
	public void update(TeamMember member) {
		LOGGER.debug("Calling updateMember() with params: member={}", member);
		if(member == null) {
			LOGGER.debug("Skipping update()");
			return;
		}
		
		create.update(Tables.MEMBER)
		.set(Tables.MEMBER.FIRST_NAME, member.getFirstName())
		.set(Tables.MEMBER.LAST_NAME, member.getLastName())
		.set(Tables.MEMBER.HIRE_DATE, member.getHireDate())
		.set(Tables.MEMBER.PHOTO_URL, member.getPhotoUrl())
		.where(Tables.MEMBER.ID.eq(member.getId())).execute();
	}

	@Override
	public void delete(long id) {
		LOGGER.debug("Calling deleteMember() with params: id={}", id);
		if(id < 0) {
			LOGGER.debug("Skipping delete()");
			return;
		}
		
		create.deleteFrom(Tables.MEMBER).where(Tables.MEMBER.ID.eq(id)).execute();
	}
}
