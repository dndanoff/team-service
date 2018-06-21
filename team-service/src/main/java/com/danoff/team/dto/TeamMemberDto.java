package com.danoff.team.dto;

import java.time.LocalDate;

import com.danoff.common.dto.IDto;

import lombok.Data;

@Data
public class TeamMemberDto implements IDto{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8449511386483592486L;
	
	private Long id;
	private String firstName;
	private String lastName;
	private String photoUrl;
	private LocalDate hireDate;
	private Long teamID;
	private String phoneNumber;
	private String Skype;
}
