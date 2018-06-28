package com.danoff.team.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.danoff.team.dto.TeamDto;
import com.danoff.team.dto.TeamMemberDto;
import com.danoff.team.model.TeamMember;
import com.danoff.team.model.TeamModel;


@Mapper(componentModel = "spring")
public interface TeamMapper {
	TeamMapper INSTANCE = Mappers.getMapper( TeamMapper.class );
	 
	TeamDto entityToDto(TeamModel member);
	List<TeamDto> entityToDto(List<TeamModel> teams);
	
	TeamMemberDto entityMemberToDtoMember(TeamMember member);
	List<TeamMemberDto> entityMemberToDtoMember(List<TeamMember> members);
	
	TeamModel dtoToEntity(TeamDto dto);
}
