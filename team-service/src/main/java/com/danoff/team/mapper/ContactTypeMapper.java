package com.danoff.team.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.danoff.team.dto.ContactTypeDto;
import com.danoff.team.model.ContactType;

@Mapper(componentModel = "spring")
public interface ContactTypeMapper {
	ContactTypeMapper INSTANCE = Mappers.getMapper( ContactTypeMapper.class );
	 
	ContactTypeDto entityToDto(ContactType member);
	List<ContactTypeDto> entityToDto(List<ContactType> members);
	
	ContactType dtoToEntity(ContactTypeDto dto);
}
