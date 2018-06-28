package com.danoff.team.repository.jooq;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.jooq.DSLContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.danoff.common.persistence.CrudRepository;
import com.danoff.team.db.Tables;
import com.danoff.team.db.tables.Team;
import com.danoff.team.db.tables.Title;
import com.danoff.team.model.TeamMember;
import com.danoff.team.model.TeamModel;

@Repository
public class JooqTeamRepository implements CrudRepository<TeamModel>{
	private final static Logger LOGGER = LoggerFactory.getLogger(JooqTeamRepository.class);

	private final DSLContext create;

	
	@Autowired
	public JooqTeamRepository(DSLContext create) {
		super();
		this.create = create;
	}

	@Override
	public long count() {
		LOGGER.debug("Calling count()");
		int result = create.fetchCount(create.selectFrom(Tables.TEAM));
		LOGGER.debug("Calling count() fetched={}", result);
		return result;
	}

	@Override
	public TeamModel findById(long id) {
		LOGGER.debug("Calling findTeam() with params: id={}", id);
		if(id < 0) {
			LOGGER.debug("Skipping findTeam()");
			return null;
		}
		
		TeamModel record = create.fetchOne(Tables.TEAM, Team.TEAM.ID.eq(id)).into(TeamModel.class);
		LOGGER.debug("Calling findMember() fetched={}", record);
		return record;
	}

	@Override
	public List<TeamModel> findPaginated(int page, int size) {
		LOGGER.debug("Calling findPaginated() with params: page={}, size={}", page, size);
		if (size < 0 || page < 0) {
			LOGGER.debug("Skipping findMember()");
			return Collections.emptyList();
		}
		
		Map<TeamModel, List<TeamMember>> result = create.select()
				.from(Tables.TEAM)
				.join(Tables.MEMBER)
				.on(Tables.MEMBER.TEAM_ID.eq(Tables.TEAM.ID))
				.limit(size).offset(page)
				.fetchGroups(
						r -> r.into(Tables.TEAM).into(TeamModel.class),
						r -> r.into(Tables.MEMBER).into(TeamMember.class)
						);
		List<TeamModel> teams = result.entrySet().stream().map(e ->{
			TeamModel team = e.getKey();
			team.setMembers(e.getValue());
			return team;
		}).collect(Collectors.toList());
		return teams;
	}

	@Override
	public TeamModel create(TeamModel entity) {
		LOGGER.debug("Calling createTeam() with params: team={}", entity);
		if(entity == null) {
			LOGGER.debug("Skipping create()");
			return null;
		}
		TeamModel record = create.insertInto(Tables.TEAM)
				.set(Tables.TEAM.NAME, entity.getName())
				.set(Tables.TEAM.PROJECT_NAME, entity.getProjectName())
				.set(Tables.TEAM.ROOM, entity.getRoom())
				.set(Tables.TEAM.ESTABLISHED_DATE, entity.getEstablishedDate())
				.set(Tables.TEAM.TECHNOLOGIES, entity.getTechnologies())
				.returning(Tables.TEAM.ID)
				.fetchOne().into(TeamModel.class);
		LOGGER.debug("Calling createTeam() returned={}", record);
		return entity;
	}

	@Override
	public void update(TeamModel entity) {
		LOGGER.debug("Calling updateTeam() with params: team={}", entity);
		if(entity == null) {
			LOGGER.debug("Skipping update()");
			return;
		}
		
		create.update(Tables.TEAM)
		.set(Tables.TEAM.NAME, entity.getName())
		.set(Tables.TEAM.PROJECT_NAME, entity.getProjectName())
		.set(Tables.TEAM.ROOM, entity.getRoom())
		.set(Tables.TEAM.ESTABLISHED_DATE, entity.getEstablishedDate())
		.set(Tables.TEAM.TECHNOLOGIES, entity.getTechnologies())
		.where(Tables.TEAM.ID.eq(entity.getId())).execute();
		
	}

	@Override
	public void delete(long id) {
		LOGGER.debug("Calling deleteTeam() with params: id={}", id);
		if(id < 0) {
			LOGGER.debug("Skipping delete()");
			return;
		}
		
		create.deleteFrom(Tables.TEAM).where(Tables.TEAM.ID.eq(id)).execute();
		
	}

	

}
