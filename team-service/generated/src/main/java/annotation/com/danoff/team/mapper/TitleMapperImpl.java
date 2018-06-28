package com.danoff.team.mapper;

import com.danoff.team.dto.TitleDto;
import com.danoff.team.model.Title;
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
public class TitleMapperImpl implements TitleMapper {

    @Override
    public TitleDto entityToDto(Title member) {
        if ( member == null ) {
            return null;
        }

        TitleDto titleDto = new TitleDto();

        titleDto.setId( member.getId() );
        titleDto.setName( member.getName() );
        titleDto.setDescription( member.getDescription() );

        return titleDto;
    }

    @Override
    public List<TitleDto> entityToDto(List<Title> members) {
        if ( members == null ) {
            return null;
        }

        List<TitleDto> list = new ArrayList<TitleDto>( members.size() );
        for ( Title title : members ) {
            list.add( entityToDto( title ) );
        }

        return list;
    }

    @Override
    public Title dtoToEntity(TitleDto dto) {
        if ( dto == null ) {
            return null;
        }

        Title title = new Title();

        title.setId( dto.getId() );
        title.setName( dto.getName() );
        title.setDescription( dto.getDescription() );

        return title;
    }
}
