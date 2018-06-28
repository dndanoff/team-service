package com.danoff.team.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.danoff.common.converter.GenericObjectConverter;
import com.danoff.team.dto.TeamMemberDto;
import com.danoff.team.model.TeamMember;

@Mapper(componentModel = "spring", uses= {TitleMapper.class, ContactTypeMapper.class})
public interface TitleMapper extends GenericObjectConverter<TeamMember, TeamMemberDto>{
	TitleMapper INSTANCE = Mappers.getMapper( TitleMapper.class );
}
