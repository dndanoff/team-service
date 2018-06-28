package com.danoff.team.model;

import com.danoff.common.model.IEntity;

import lombok.Data;

@Data
public class ContactType implements IEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4067160640079596440L;
	
	private Long id;
	private String name;
	private Integer priority;
	private String value; 
}