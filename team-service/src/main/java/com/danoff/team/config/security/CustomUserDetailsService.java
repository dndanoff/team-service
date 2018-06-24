package com.danoff.team.config.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.danoff.team.config.ApplicationProperties;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
    private static final Map<String, UserObject> users = new HashMap<>();
    
    private final ApplicationProperties appConfig;

    @Autowired
    public CustomUserDetailsService(ApplicationProperties appConfig) {
    	this.appConfig = appConfig;
    	populateUsers();
    }
    
    private void populateUsers() {
		users.put(appConfig.getAdminUsername(),
				new UserObject(appConfig.getAdminUsername(),
								appConfig.getAdminPassword(),
								ApplicationRoles.ADMIN.getRoleName(),
								ApplicationRoles.ACTUATOR.getRoleName()));
		users.put(appConfig.getApiClientUsername(),
				new UserObject(appConfig.getApiClientUsername(),
								appConfig.getApiClientPassword(),
								ApplicationRoles.USER.getRoleName()));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserObject user = users.get(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found by name: " + username);
        }
        return toUserDetails(user);
    }

    private UserDetails toUserDetails(UserObject userObject) {
        return User.withUsername(userObject.name)
                   .password(userObject.password)
                   .roles(userObject.roles).build();
    }

    private class UserObject {
    	
        private String name;
        private String password;
        private String[] roles;

        public UserObject(String name, String password, String... roles) {
            this.name = name;
            this.password = password;
            this.roles = roles;
        }
    }

}
