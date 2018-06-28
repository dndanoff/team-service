package com.danoff.team.dto;

import java.time.LocalDate;
import java.util.List;

import com.danoff.common.dto.IDto;
import com.danoff.common.dto.views.DtoView;
import com.danoff.team.model.TeamMember;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.Data;

@Data
public class TeamDto implements IDto{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonView(DtoView.Aggregated.class)
	private Long id;
	@JsonView(DtoView.Aggregated.class)
	private String name;
	@JsonView(DtoView.Aggregated.class)
	private String projectName;
	@JsonView(DtoView.Aggregated.class)
	private LocalDate establishedDate;
	@JsonView(DtoView.Aggregated.class)
	private String room;
	@JsonView(DtoView.Aggregated.class)
	private String technologies;
	@JsonView(DtoView.Aggregated.class)
	private List<TeamMemberDto> members;
	
}
