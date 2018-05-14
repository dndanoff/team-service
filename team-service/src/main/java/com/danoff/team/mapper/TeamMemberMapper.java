package com.danoff.team.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.danoff.team.db.tables.records.MemberRecord;
import com.danoff.team.dto.TeamMemberDto;
import com.danoff.team.model.TeamMember;

@Mapper(componentModel = "spring")
public interface TeamMemberMapper {
	TeamMemberMapper INSTANCE = Mappers.getMapper( TeamMemberMapper.class );
	 
	TeamMember memberRecordToTeamMember(MemberRecord record);
	TeamMemberDto teamMemberToTeamMemberDto(TeamMember member);
	TeamMember teamMemberDtoToTeamMember(TeamMemberDto dto);
}
