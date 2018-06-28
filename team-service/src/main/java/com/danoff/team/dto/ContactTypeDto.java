package com.danoff.team.dto;

import com.danoff.common.dto.IDto;
import com.danoff.common.dto.views.DtoView;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.Data;

@Data
public class ContactTypeDto implements IDto{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4067160640079596440L;
	
	@JsonView(DtoView.Aggregated.class)
	private Long id;
	@JsonView(DtoView.Aggregated.class)
	private String name;
	@JsonView(DtoView.Aggregated.class)
	private Integer priority;
	@JsonView(DtoView.Detailed.class)
	private String value;
}