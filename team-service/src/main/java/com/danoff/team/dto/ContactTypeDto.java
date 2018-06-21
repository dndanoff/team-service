package com.danoff.team.dto;

import com.danoff.common.dto.IDto;

import lombok.Data;

@Data
public class ContactTypeDto implements IDto{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4067160640079596440L;
	
	private Long id;
	private String name;
	private Integer priority;
}