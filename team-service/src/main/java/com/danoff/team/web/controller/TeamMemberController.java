package com.danoff.team.web.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.danoff.common.web.RestPreconditions;
import com.danoff.team.dto.TeamMemberDto;
import com.danoff.team.mapper.TeamMemberMapper;
import com.danoff.team.model.TeamMember;
import com.danoff.team.service.TeamService;

@RestController
@RequestMapping(value = "/members")
public class TeamMemberController {

	private final static Logger LOGGER = LoggerFactory.getLogger(TeamMemberController.class);

	private final TeamService teamService;
	private final TeamMemberMapper mapper;

	@Autowired
	public TeamMemberController(TeamService teamService, TeamMemberMapper mapper) {
		this.teamService = teamService;
		this.mapper = mapper;
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<TeamMemberDto>> getAllMembers(
			@RequestParam(name = "pageSize", defaultValue = "25", required = false) int pageSize,
			@RequestParam(name = "pageNumber", defaultValue = "0", required = false) int pageNumber) {
		LOGGER.debug("Received request to display all team members.");
		List<TeamMember> members = teamService.findMembers(pageSize, pageNumber);
		return new ResponseEntity<>(members.stream().map(m -> mapper.teamMemberToTeamMemberDto(m))
				.collect(Collectors.toList()), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<TeamMemberDto> createMember(@RequestBody TeamMemberDto memberDto) {
		RestPreconditions.checkRequestElementNotNull(memberDto);
        RestPreconditions.checkRequestState(memberDto.getId() == null);
        
        teamService.createMember(mapper.teamMemberDtoToTeamMember(memberDto));
        
        return new ResponseEntity<>(memberDto, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Void> updateMember(@PathVariable Long id, @RequestBody TeamMemberDto memberDto) {
		RestPreconditions.checkRequestElementNotNull(memberDto);
        RestPreconditions.checkRequestElementNotNull(memberDto.getId());
        RestPreconditions.checkRequestState(memberDto.getId() == id);
        RestPreconditions.checkNotNull(teamService.findMember(memberDto.getId()));
        
        teamService.updateMember(mapper.teamMemberDtoToTeamMember(memberDto));
        
        return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Void> deleteMember(@PathVariable Long id) {
		RestPreconditions.checkRequestElementNotNull(id);
		RestPreconditions.checkNotNull(teamService.findMember(id));
        
		teamService.deleteMember(id);
		
        return new ResponseEntity<>(HttpStatus.OK);
	}

}
