package com.danoff.team.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class TeamMemberDto {
	private Long id;
	private String email;
	private String firstName;
	private String lastName;
	private String photoUrl;
	private LocalDate hireDate;
}
