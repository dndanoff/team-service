package com.danoff.team.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;

@Configuration
@PropertySources({
	@PropertySource("classpath:application.properties"),
    @PropertySource("classpath:db/db-${spring.profiles.active:dev}.properties")
})
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
	
	public String getApiClientUsername() {
		return env.getProperty("security.user.username");
	}
	
	public String getApiClientPassword() {
		return env.getProperty("security.user.password");
	}
}
