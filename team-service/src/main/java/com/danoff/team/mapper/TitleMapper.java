package com.danoff.team.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.danoff.common.converter.GenericObjectConverter;
import com.danoff.team.dto.TitleDto;
import com.danoff.team.model.Title;

@Mapper(componentModel = "spring")
public interface TitleMapper  extends GenericObjectConverter<Title, TitleDto>{
	TitleMapper INSTANCE = Mappers.getMapper( TitleMapper.class );
}
