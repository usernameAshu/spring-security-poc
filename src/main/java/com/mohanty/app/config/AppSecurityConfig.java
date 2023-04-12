package com.mohanty.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class AppSecurityConfig {

	@Bean
	UserDetailsService userDetailsService() {
		UserDetails ashutosh = User.withDefaultPasswordEncoder()
				.username("ashutosh")
				.password("password")
				.roles("USER")
				.build();
		
		UserDetails anuja = User.withDefaultPasswordEncoder()
				.username("anuja")
				.password("password")
				.roles("USER")
				.build();
		
		return new InMemoryUserDetailsManager(ashutosh, anuja);
	}
}
