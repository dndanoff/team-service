package com.danoff.team.mapper;

import com.danoff.team.dto.TeamDto;
import com.danoff.team.dto.TeamMemberDto;
import com.danoff.team.model.TeamMember;
import com.danoff.team.model.TeamModel;
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
public class TeamMapperImpl implements TeamMapper {

    @Override
    public TeamDto entityToDto(TeamModel member) {
        if ( member == null ) {
            return null;
        }

        TeamDto teamDto = new TeamDto();

        teamDto.setId( member.getId() );
        teamDto.setName( member.getName() );
        teamDto.setProjectName( member.getProjectName() );
        teamDto.setEstablishedDate( member.getEstablishedDate() );
        teamDto.setRoom( member.getRoom() );
        teamDto.setTechnologies( member.getTechnologies() );
        teamDto.setMembers( entityMemberToDtoMember( member.getMembers() ) );

        return teamDto;
    }

    @Override
    public List<TeamDto> entityToDto(List<TeamModel> teams) {
        if ( teams == null ) {
            return null;
        }

        List<TeamDto> list = new ArrayList<TeamDto>( teams.size() );
        for ( TeamModel teamModel : teams ) {
            list.add( entityToDto( teamModel ) );
        }

        return list;
    }

    @Override
    public TeamMemberDto entityMemberToDtoMember(TeamMember member) {
        if ( member == null ) {
            return null;
        }

        TeamMemberDto teamMemberDto = new TeamMemberDto();

        teamMemberDto.setId( member.getId() );
        teamMemberDto.setFirstName( member.getFirstName() );
        teamMemberDto.setLastName( member.getLastName() );
        teamMemberDto.setPhotoUrl( member.getPhotoUrl() );
        teamMemberDto.setHireDate( member.getHireDate() );
        teamMemberDto.setTeamId( member.getTeamId() );

        return teamMemberDto;
    }

    @Override
    public List<TeamMemberDto> entityMemberToDtoMember(List<TeamMember> members) {
        if ( members == null ) {
            return null;
        }

        List<TeamMemberDto> list = new ArrayList<TeamMemberDto>( members.size() );
        for ( TeamMember teamMember : members ) {
            list.add( entityMemberToDtoMember( teamMember ) );
        }

        return list;
    }

    @Override
    public TeamModel dtoToEntity(TeamDto dto) {
        if ( dto == null ) {
            return null;
        }

        TeamModel teamModel = new TeamModel();

        teamModel.setId( dto.getId() );
        teamModel.setName( dto.getName() );
        teamModel.setProjectName( dto.getProjectName() );
        teamModel.setEstablishedDate( dto.getEstablishedDate() );
        teamModel.setRoom( dto.getRoom() );
        teamModel.setTechnologies( dto.getTechnologies() );
        teamModel.setMembers( teamMemberDtoListToTeamMemberList( dto.getMembers() ) );

        return teamModel;
    }

    protected TeamMember teamMemberDtoToTeamMember(TeamMemberDto teamMemberDto) {
        if ( teamMemberDto == null ) {
            return null;
        }

        TeamMember teamMember = new TeamMember();

        teamMember.setId( teamMemberDto.getId() );
        teamMember.setFirstName( teamMemberDto.getFirstName() );
        teamMember.setLastName( teamMemberDto.getLastName() );
        teamMember.setPhotoUrl( teamMemberDto.getPhotoUrl() );
        teamMember.setHireDate( teamMemberDto.getHireDate() );
        teamMember.setTeamId( teamMemberDto.getTeamId() );

        return teamMember;
    }

    protected List<TeamMember> teamMemberDtoListToTeamMemberList(List<TeamMemberDto> list) {
        if ( list == null ) {
            return null;
        }

        List<TeamMember> list1 = new ArrayList<TeamMember>( list.size() );
        for ( TeamMemberDto teamMemberDto : list ) {
            list1.add( teamMemberDtoToTeamMember( teamMemberDto ) );
        }

        return list1;
    }
}
