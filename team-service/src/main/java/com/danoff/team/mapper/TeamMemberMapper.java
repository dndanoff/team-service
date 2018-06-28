package com.danoff.team.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.danoff.common.converter.GenericObjectConverter;
import com.danoff.team.dto.TeamMemberDto;
import com.danoff.team.model.TeamMember;

@Mapper(componentModel = "spring", uses= {TitleMapper.class, ContactTypeMapper.class})
public interface TeamMemberMapper extends GenericObjectConverter<TeamMember, TeamMemberDto> {
	TeamMemberMapper INSTANCE = Mappers.getMapper( TeamMemberMapper.class );
	 
	TeamMemberDto entityToDto(TeamMember member);
	List<TeamMemberDto> entityToDto(List<TeamMember> members);
	
	TeamMember dtoToEntity(TeamMemberDto dto);
}
