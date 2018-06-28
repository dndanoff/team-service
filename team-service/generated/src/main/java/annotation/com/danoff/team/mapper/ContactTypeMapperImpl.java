package com.danoff.team.mapper;

import com.danoff.team.dto.ContactTypeDto;
import com.danoff.team.model.ContactType;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-06-24T00:53:25+0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_121 (Oracle Corporation)"
)
@Component
public class ContactTypeMapperImpl implements ContactTypeMapper {

    @Override
    public ContactTypeDto entityToDto(ContactType member) {
        if ( member == null ) {
            return null;
        }

        ContactTypeDto contactTypeDto = new ContactTypeDto();

        contactTypeDto.setId( member.getId() );
        contactTypeDto.setName( member.getName() );
        contactTypeDto.setPriority( member.getPriority() );

        return contactTypeDto;
    }

    @Override
    public List<ContactTypeDto> entityToDto(List<ContactType> members) {
        if ( members == null ) {
            return null;
        }

        List<ContactTypeDto> list = new ArrayList<ContactTypeDto>( members.size() );
        for ( ContactType contactType : members ) {
            list.add( entityToDto( contactType ) );
        }

        return list;
    }

    @Override
    public ContactType dtoToEntity(ContactTypeDto dto) {
        if ( dto == null ) {
            return null;
        }

        ContactType contactType = new ContactType();

        contactType.setId( dto.getId() );
        contactType.setName( dto.getName() );
        contactType.setPriority( dto.getPriority() );

        return contactType;
    }
}
