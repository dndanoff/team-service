package com.danoff.team.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.danoff.common.converter.GenericObjectConverter;
import com.danoff.team.dto.ContactTypeDto;
import com.danoff.team.model.ContactType;

@Mapper(componentModel = "spring")
public interface ContactTypeMapper extends GenericObjectConverter<ContactType, ContactTypeDto>{
	ContactTypeMapper INSTANCE = Mappers.getMapper( ContactTypeMapper.class );
}
