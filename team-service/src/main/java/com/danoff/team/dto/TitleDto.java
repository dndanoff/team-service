package com.danoff.team.dto;

import com.danoff.common.dto.IDto;

import lombok.Data;

@Data
public class TitleDto implements IDto {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2732713111949968024L;
	
	private Long id;
	private String name;
	private String description;
}