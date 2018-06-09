package com.danoff.team.repository.jooq;

import java.util.List;
import java.util.stream.Collectors;

import org.jooq.DSLContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.danoff.team.db.tables.Member;
import com.danoff.team.db.tables.records.MemberRecord;
import com.danoff.team.mapper.TeamMemberMapper;
import com.danoff.team.model.TeamMember;
import com.danoff.team.repository.TeamMemberRepository;

@Repository
public class JooqTeamMemberRepository implements TeamMemberRepository {

	private final static Logger LOGGER = LoggerFactory.getLogger(JooqTeamMemberRepository.class);

	private final DSLContext create;
	private final TeamMemberMapper mapper;

	@Autowired
	public JooqTeamMemberRepository(DSLContext dsl, TeamMemberMapper mapper) {
		this.create = dsl;
		this.mapper = mapper;
	}

	@Override
	public List<TeamMember> findAll() {
		LOGGER.debug("Calling findAll()");
		List<TeamMember> result = create.selectFrom(Member.MEMBER).fetch().stream()
				.map(r -> TeamMemberMapper.INSTANCE.memberRecordToTeamMember(r)).collect(Collectors.toList());
		LOGGER.debug("Calling findAll() fetched={}", result);
		return result;
	}

	@Override
	public List<TeamMember> findPaginated(int pageSize, int pageNumber) {
		LOGGER.debug("Calling findPaginated() with params: pageSize={}, pageNumber={}", pageSize, pageNumber);
		List<TeamMember> result = create.selectFrom(Member.MEMBER).limit(pageSize).offset(pageNumber).fetch().stream()
				.map(r -> mapper.memberRecordToTeamMember(r)).collect(Collectors.toList());
		LOGGER.debug("Calling findPaginated() fetched={}", result);
		return result;
	}

	@Override
	public int count() {
		LOGGER.debug("Calling count()");
		int result = create.fetchCount(create.selectFrom(Member.MEMBER));
		LOGGER.debug("Calling count() fetched={}", result);
		return result;
	}

	@Override
	public TeamMember findMember(Long id) {
		LOGGER.debug("Calling findMember() with params: id={}", id);
		MemberRecord record = create.fetchOne(Member.MEMBER, Member.MEMBER.ID.eq(id));
		LOGGER.debug("Calling findMember() fetched={}", record);
		return mapper.memberRecordToTeamMember(record);
	}

	@Override
	public Long createMember(TeamMember member) {
		LOGGER.debug("Calling createMember() with params: member={}", member);
		MemberRecord record = create.insertInto(Member.MEMBER)
		.set(Member.MEMBER.FIRST_NAME, member.getFirstName())
		.set(Member.MEMBER.LAST_NAME, member.getLastName())
		.set(Member.MEMBER.EMAIL, member.getEmail())
		.set(Member.MEMBER.HIRE_DATE, member.getHireDate())
		.set(Member.MEMBER.PHOTO_URL, member.getPhotoUrl())
		.returning(Member.MEMBER.ID)
		.fetchOne();
		LOGGER.debug("Calling createMember() returned={}", record.getId());
		
		return new Long(record.getId().intValue());
	}

	@Override
	public void updateMember(TeamMember member) {
		LOGGER.debug("Calling updateMember() with params: member={}", member);
		create.update(Member.MEMBER)
		.set(Member.MEMBER.FIRST_NAME, member.getFirstName())
		.set(Member.MEMBER.LAST_NAME, member.getLastName())
		.set(Member.MEMBER.EMAIL, member.getEmail())
		.set(Member.MEMBER.HIRE_DATE, member.getHireDate())
		.set(Member.MEMBER.PHOTO_URL, member.getPhotoUrl())
		.where(Member.MEMBER.ID.eq(member.getId())).execute();
	}

	@Override
	public void deleteMember(Long id) {
		LOGGER.debug("Calling deleteMember() with params: id={}", id);
		create.deleteFrom(Member.MEMBER).where(Member.MEMBER.ID.eq(id)).execute();
	}

}
