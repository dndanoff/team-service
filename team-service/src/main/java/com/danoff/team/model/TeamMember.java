package com.danoff.team.model;

import java.time.LocalDate;
import java.util.List;

import com.danoff.common.model.IEntity;

import lombok.Data;

@Data
public class TeamMember  implements IEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6535294045883015492L;
	
	private Long id;
	private String firstName;
	private String lastName;
	private String photoUrl;
	private LocalDate hireDate;
	private Title title;
	private List<ContactType> contacts;
}