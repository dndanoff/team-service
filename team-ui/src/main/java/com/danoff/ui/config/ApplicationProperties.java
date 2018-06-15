package com.danoff.ui.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class ApplicationProperties {
	
	private final Environment env;
	
	@Autowired
	public ApplicationProperties(Environment env) {
		this.env = env;
	}
	
	public String getAdminUsername() {
		return env.getProperty("security.admin.username");
	}
	
	public String getAdminPassword() {
		return env.getProperty("security.admin.password");
	}
	
	public String getMembersResourceUsername() {
		return env.getProperty("resource.members.username");
	}
	
	public String getMembersResourcePassword() {
		return env.getProperty("resource.members.password");
	}
}
