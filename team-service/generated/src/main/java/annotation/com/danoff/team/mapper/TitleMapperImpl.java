package com.danoff.team.mapper;

import com.danoff.team.dto.TitleDto;
import com.danoff.team.model.Title;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-06-23T00:13:33+0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
@Component
public class TitleMapperImpl implements TitleMapper {

    @Override
    public Title dtoToEntity(TitleDto arg0) {
        if ( arg0 == null ) {
            return null;
        }

        Title title = new Title();

        title.setId( arg0.getId() );
        title.setName( arg0.getName() );
        title.setDescription( arg0.getDescription() );

        return title;
    }

    @Override
    public TitleDto entityToDto(Title arg0) {
        if ( arg0 == null ) {
            return null;
        }

        TitleDto titleDto = new TitleDto();

        titleDto.setId( arg0.getId() );
        titleDto.setName( arg0.getName() );
        titleDto.setDescription( arg0.getDescription() );

        return titleDto;
    }
}
