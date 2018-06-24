package com.danoff.team.config.security;

public enum ApplicationRoles {
	ADMIN("ADMIN"),
	ACTUATOR("ACTUATOR"),
	USER("USER");
	
	private final String roleName;
	
	private ApplicationRoles(String roleName){
		this.roleName = roleName;
	}

	public String getRoleName() {
		return roleName;
	}
}
