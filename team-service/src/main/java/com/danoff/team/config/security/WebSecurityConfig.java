package com.danoff.team.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	private static final int ENCODER_STRENGTH = 16;
	
	private final UserDetailsService userDetailsService;
	
	@Autowired
	public WebSecurityConfig(UserDetailsService userDetailsService){
		this.userDetailsService = userDetailsService;
	}
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        	.csrf()
        		.disable()
        	.authorizeRequests()
        		.antMatchers("/management/info","/management/health").permitAll()
        		.antMatchers("/members/**","/titles/**","/contact-types/**", "/swagger-ui").hasAnyRole(
        				ApplicationRoles.USER.getRoleName(),
        				ApplicationRoles.ADMIN.getRoleName())
        		.anyRequest().hasRole(ApplicationRoles.ADMIN.getRoleName())
        	.and()
        		.httpBasic()
        	.and().exceptionHandling()
	        	.defaultAuthenticationEntryPointFor(adminAauthenticationEntryPoint(), new AntPathRequestMatcher("/management/**"))
	        	.defaultAuthenticationEntryPointFor(generalAuthenticationEntryPoint(), new AntPathRequestMatcher("/**"));
        http.headers().frameOptions().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
     
    @Bean
    public PasswordEncoder passwordEncoder() {
//    	return NoOpPasswordEncoder.getInstance();
    	PasswordEncoder encoder = new BCryptPasswordEncoder(ENCODER_STRENGTH);
        return encoder;
    }
    
    @Bean
    public AuthenticationEntryPoint generalAuthenticationEntryPoint(){
        BasicAuthenticationEntryPoint entryPoint = 
          new BasicAuthenticationEntryPoint();
        entryPoint.setRealmName("Dreamix members' realm");
        return entryPoint;
    }
    
    @Bean
    public AuthenticationEntryPoint adminAauthenticationEntryPoint(){
        BasicAuthenticationEntryPoint entryPoint = 
          new BasicAuthenticationEntryPoint();
        entryPoint.setRealmName("Dreamix admin's realm");
        return entryPoint;
    }
}
