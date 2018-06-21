package com.danoff.team.mapper;

import com.danoff.team.db.tables.records.MemberRecord;
import com.danoff.team.dto.TeamMemberDto;
import com.danoff.team.model.TeamMember;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-06-17T20:55:17+0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_121 (Oracle Corporation)"
)
@Component
public class TeamMemberMapperImpl implements TeamMemberMapper {

    @Override
    public TeamMember memberRecordToTeamMember(MemberRecord record) {
        if ( record == null ) {
            return null;
        }

        TeamMember teamMember = new TeamMember();

        teamMember.setId( record.getId() );
        teamMember.setEmail( record.getEmail() );
        teamMember.setFirstName( record.getFirstName() );
        teamMember.setLastName( record.getLastName() );
        teamMember.setPhotoUrl( record.getPhotoUrl() );
        teamMember.setHireDate( record.getHireDate() );

        return teamMember;
    }

    @Override
    public TeamMemberDto teamMemberToTeamMemberDto(TeamMember member) {
        if ( member == null ) {
            return null;
        }

        TeamMemberDto teamMemberDto = new TeamMemberDto();

        teamMemberDto.setId( member.getId() );
        teamMemberDto.setEmail( member.getEmail() );
        teamMemberDto.setFirstName( member.getFirstName() );
        teamMemberDto.setLastName( member.getLastName() );
        teamMemberDto.setPhotoUrl( member.getPhotoUrl() );
        teamMemberDto.setHireDate( member.getHireDate() );

        return teamMemberDto;
    }

    @Override
    public TeamMember teamMemberDtoToTeamMember(TeamMemberDto dto) {
        if ( dto == null ) {
            return null;
        }

        TeamMember teamMember = new TeamMember();

        teamMember.setId( dto.getId() );
        teamMember.setEmail( dto.getEmail() );
        teamMember.setFirstName( dto.getFirstName() );
        teamMember.setLastName( dto.getLastName() );
        teamMember.setPhotoUrl( dto.getPhotoUrl() );
        teamMember.setHireDate( dto.getHireDate() );

        return teamMember;
    }
}
