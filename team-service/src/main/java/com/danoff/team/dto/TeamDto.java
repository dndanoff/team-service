package com.danoff.team.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class TeamDto {
	private Long id;
	private String Name;
	private String projectName;
	private LocalDate establishedDate;
	private String room;
	private String technologies;
	
}
