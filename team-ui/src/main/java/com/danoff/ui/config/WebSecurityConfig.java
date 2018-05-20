package com.danoff.ui.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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
        	.httpBasic()
        		.and()
        	.authorizeRequests()
        		.antMatchers("/app/**").hasAnyRole("ADMIN")
        		.anyRequest().permitAll();
        http.headers().frameOptions().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        auth.inMemoryAuthentication().passwordEncoder(passwordEncoder)
                .withUser(appConfig.getAdminUsername()).password(passwordEncoder.encode(appConfig.getAdminPassword())).roles("ADMIN","ACTUATOR");
    }
}
