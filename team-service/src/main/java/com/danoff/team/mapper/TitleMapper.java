package com.danoff.team.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.danoff.team.dto.TitleDto;
import com.danoff.team.model.Title;

@Mapper(componentModel = "spring")
public interface TitleMapper {
	TitleMapper INSTANCE = Mappers.getMapper( TitleMapper.class );
	 
	TitleDto entityToDto(Title member);
	List<TitleDto> entityToDto(List<Title> members);
	
	Title dtoToEntity(TitleDto dto);
}
