package com.danoff.team.mapper;

import com.danoff.team.dto.TeamMemberDto;
import com.danoff.team.model.TeamMember;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-06-21T22:51:08+0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
@Component
public class TeamMemberMapperImpl implements TeamMemberMapper {

    @Override
    public TeamMemberDto entityToDto(TeamMember member) {
        if ( member == null ) {
            return null;
        }

        TeamMemberDto teamMemberDto = new TeamMemberDto();

        teamMemberDto.setId( member.getId() );
        teamMemberDto.setFirstName( member.getFirstName() );
        teamMemberDto.setLastName( member.getLastName() );
        teamMemberDto.setPhotoUrl( member.getPhotoUrl() );
        teamMemberDto.setHireDate( member.getHireDate() );

        return teamMemberDto;
    }

    @Override
    public List<TeamMemberDto> entityToDto(List<TeamMember> members) {
        if ( members == null ) {
            return null;
        }

        List<TeamMemberDto> list = new ArrayList<TeamMemberDto>( members.size() );
        for ( TeamMember teamMember : members ) {
            list.add( entityToDto( teamMember ) );
        }

        return list;
    }

    @Override
    public TeamMember dtoToEntity(TeamMemberDto dto) {
        if ( dto == null ) {
            return null;
        }

        TeamMember teamMember = new TeamMember();

        teamMember.setId( dto.getId() );
        teamMember.setFirstName( dto.getFirstName() );
        teamMember.setLastName( dto.getLastName() );
        teamMember.setPhotoUrl( dto.getPhotoUrl() );
        teamMember.setHireDate( dto.getHireDate() );

        return teamMember;
    }
}
