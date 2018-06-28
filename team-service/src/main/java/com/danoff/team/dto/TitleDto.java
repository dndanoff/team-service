package com.danoff.team.dto;

import com.danoff.common.dto.IDto;
import com.danoff.common.dto.views.DtoView;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.Data;

@Data
public class TitleDto implements IDto {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2732713111949968024L;
	
	@JsonView(DtoView.Aggregated.class)
	private Long id;
	@JsonView(DtoView.Aggregated.class)
	private String name;
	@JsonView(DtoView.Aggregated.class)
	private String description;
}