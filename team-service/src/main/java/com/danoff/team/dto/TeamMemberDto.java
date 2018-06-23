package com.danoff.team.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.danoff.common.dto.IDto;
import com.danoff.common.dto.views.DtoView;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.Data;

@Data
public class TeamMemberDto implements IDto{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8449511386483592486L;
	
	@JsonView(DtoView.Aggregated.class)
	private Long id;
	@JsonView(DtoView.Aggregated.class)
	private String firstName;
	@JsonView(DtoView.Aggregated.class)
	private String lastName;
	@JsonView(DtoView.Aggregated.class)
	private String photoUrl;
	@JsonView(DtoView.Aggregated.class)
	private LocalDate hireDate;
	@JsonView(DtoView.Aggregated.class)
	private TitleDto title;
	
	@JsonView(DtoView.Detailed.class)
	private List<ContactTypeDto> contacts;
	
	@JsonIgnore
	public List<ContactTypeDto> getContacts() {
		List<ContactTypeDto> result = new ArrayList<>();
		if(contacts != null) {
			result.addAll(contacts);
		}
		
		return result;
	}
}
