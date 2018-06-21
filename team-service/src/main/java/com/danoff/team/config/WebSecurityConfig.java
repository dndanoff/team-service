package com.danoff.team.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	private final ApplicationProperties appConfig;
	
	@Autowired
	public WebSecurityConfig(ApplicationProperties appConfig){
		this.appConfig = appConfig;
	}
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        	.csrf()
        		.disable()
        	.authorizeRequests()
        		.antMatchers("/management/info","/management/health").permitAll()
        		.antMatchers("/members", "/swagger-ui").permitAll()//hasAnyRole("USER", "ADMIN")
        		.anyRequest().hasRole("ADMIN")
        	.and()
        		.httpBasic();
        http.headers().frameOptions().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser(appConfig.getAdminUsername()).password(appConfig.getAdminPassword()).roles("ADMIN","ACTUATOR")
                .and()
                .withUser(appConfig.getApiClientUsername()).password(appConfig.getApiClientPassword()).roles("USER");
    }
}
