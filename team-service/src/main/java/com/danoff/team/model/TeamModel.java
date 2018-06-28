package com.danoff.team.model;

import java.time.LocalDate;
import java.util.List;

import com.danoff.common.model.IEntity;

import lombok.Data;

@Data
public class TeamModel implements IEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String Name;
	private String projectName;
	private LocalDate establishedDate;
	private String room;
	private String technologies;
	private List<TeamMember> members;
	
}
