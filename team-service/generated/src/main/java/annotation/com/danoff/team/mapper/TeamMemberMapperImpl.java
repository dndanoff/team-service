package com.danoff.team.mapper;

import com.danoff.team.dto.TeamMemberDto;
import com.danoff.team.model.TeamMember;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-06-23T00:13:33+0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
@Component
public class TeamMemberMapperImpl implements TeamMemberMapper {

    @Autowired
    private TitleMapper titleMapper;
    @Autowired
    private ContactTypeMapper contactTypeMapper;

    @Override
    public TeamMember dtoToEntity(TeamMemberDto arg0) {
        if ( arg0 == null ) {
            return null;
        }

        TeamMember teamMember = new TeamMember();

        teamMember.setId( arg0.getId() );
        teamMember.setFirstName( arg0.getFirstName() );
        teamMember.setLastName( arg0.getLastName() );
        teamMember.setPhotoUrl( arg0.getPhotoUrl() );
        teamMember.setHireDate( arg0.getHireDate() );
        teamMember.setTitle( titleMapper.dtoToEntity( arg0.getTitle() ) );
        teamMember.setContacts( contactTypeMapper.dtoToEntity( arg0.getContacts() ) );

        return teamMember;
    }

    @Override
    public TeamMemberDto entityToDto(TeamMember arg0) {
        if ( arg0 == null ) {
            return null;
        }

        TeamMemberDto teamMemberDto = new TeamMemberDto();

        teamMemberDto.setId( arg0.getId() );
        teamMemberDto.setFirstName( arg0.getFirstName() );
        teamMemberDto.setLastName( arg0.getLastName() );
        teamMemberDto.setPhotoUrl( arg0.getPhotoUrl() );
        teamMemberDto.setHireDate( arg0.getHireDate() );
        teamMemberDto.setTitle( titleMapper.entityToDto( arg0.getTitle() ) );
        teamMemberDto.setContacts( contactTypeMapper.entityToDto( arg0.getContacts() ) );

        return teamMemberDto;
    }
}
