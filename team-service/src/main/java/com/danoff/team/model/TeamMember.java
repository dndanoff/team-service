package com.danoff.team.model;

import java.time.LocalDate;

import com.danoff.common.model.IEntity;

import lombok.Data;

@Data
public class TeamMember  implements IEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6535294045883015492L;
	
	private Long id;
	private String email;
	private String firstName;
	private String lastName;
	private String photoUrl;
	private LocalDate hireDate;
}