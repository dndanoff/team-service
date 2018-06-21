package com.danoff.team.model;

import com.danoff.common.model.IEntity;

import lombok.Data;

@Data
public class Title implements IEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2732713111949968024L;
	
	private Long id;
	private String name;
	private String description;
}