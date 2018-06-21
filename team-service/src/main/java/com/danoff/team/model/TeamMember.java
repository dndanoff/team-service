package com.danoff.team.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class TeamMember {
	private Long id;
	private String email;
	private String firstName;
	private String lastName;
	private String photoUrl;
	private LocalDate hireDate;
	private Long teamID;
	private String phoneNumber;
	private String Skype;
}
