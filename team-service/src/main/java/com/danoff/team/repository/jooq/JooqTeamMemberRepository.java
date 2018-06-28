package com.danoff.team.repository.jooq;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.danoff.common.persistence.CrudRepository;
import com.danoff.team.db.Tables;
import com.danoff.team.db.tables.Member;
import com.danoff.team.model.ContactType;
import com.danoff.team.model.TeamMember;
import com.danoff.team.model.Title;





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
		
		Result<?> result = create.select()
				.from(Tables.MEMBER)
				.join(Tables.TITLE)
				.on(Tables.TITLE.ID.eq(Tables.MEMBER.TITLE_ID))
				.leftJoin(Tables.MEMBER_CONTACT)
				.on(Tables.MEMBER.ID.eq(Tables.MEMBER_CONTACT.MEMBER_ID))
				.join(Tables.CONTACT_TYPE)
				.on(Tables.MEMBER_CONTACT.CONTACT_TYPE_ID.eq(Tables.CONTACT_TYPE.ID))
				.where(Member.MEMBER.ID.eq(id))
				.fetch();
		
		TeamMember member =  result.into(Tables.MEMBER.fields()).into(TeamMember.class).stream().findFirst().orElse(null);
		if(member == null) {
			return null;
		}
		
		member.setTitle(result.into(Tables.TITLE.fields()).into(Title.class).stream().findFirst().orElse(null));
		member.setContacts(result
				.into(expandFields(Tables.CONTACT_TYPE.fields(),
						Tables.MEMBER_CONTACT.field(Tables.MEMBER_CONTACT.VALUE.getName())))
				.into(ContactType.class).stream().sorted(Comparator.comparing(ContactType::getPriority))
				.collect(Collectors.toList()));

		LOGGER.debug("Calling findMember() fetched={}", member);
		return member;
	}

	public List<TeamMember> findAll() {
		LOGGER.debug("Calling findAll()");
		Map<TeamMember, List<Title>> result = create.select()
										.from(Tables.MEMBER)
										.join(Tables.TITLE)
										.on(Tables.TITLE.ID.eq(Tables.MEMBER.TITLE_ID))
										.fetchGroups(
									       r -> r.into(Tables.MEMBER).into(TeamMember.class),
									       r -> r.into(Tables.TITLE).into(Title.class)
										);
		List<TeamMember> members =  result.entrySet()
											.stream().map(e -> {
												TeamMember m = e.getKey();
												m.setTitle(e.getValue().stream().findFirst().orElse(null));
												return m;
											}).collect(Collectors.toList());
		LOGGER.debug("Calling findAll() fetched={}", members);
		return members;
	}

	@Override
	public List<TeamMember> findPaginated(int page, int size) {
		LOGGER.debug("Calling findPaginated() with params: page={}, size={}", page, size);
		if (size < 0 || page < 0) {
			LOGGER.debug("Skipping findMember()");
			return Collections.emptyList();
		}
		Map<TeamMember, List<Title>> result = create.select()
													.from(Tables.MEMBER)
													.join(Tables.TITLE)
													.on(Tables.TITLE.ID.eq(Tables.MEMBER.TITLE_ID))
													.limit(size).offset(page)
													.fetchGroups(
														r -> r.into(Tables.MEMBER).into(TeamMember.class),
														r -> r.into(Tables.TITLE).into(Title.class)
													);
		List<TeamMember> members =  result.entrySet()
											.stream().map(e -> {
												TeamMember m = e.getKey();
												m.setTitle(e.getValue().stream().findFirst().orElse(null));
												return m;
											}).collect(Collectors.toList());
		LOGGER.debug("Calling findPaginated() fetched={}", members);
		return members;
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
	
	private Field<?>[] expandFields(Field<?>[] fields, Field<?>... field){
		Field<?>[] newFields = new Field[fields.length+1];
		System.arraycopy(fields, 0, newFields, 0, fields.length);
		for(int i=fields.length,j=0; i<newFields.length; i++,j++) {
			newFields[i] = field[j];
		}
		
		return newFields;
}
}
