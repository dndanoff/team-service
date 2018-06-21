package com.danoff.team.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Team {
	private Long id;
	private String Name;
	private String projectName;
	private LocalDate establishedDate;
	private String room;
	private String technologies;
	
}
