package com.mohanty.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class AppSecurityConfig {
	
	/**
	 * Using in-memory username/password
	 * @return
	 */
	@Bean
	UserDetailsService userDetailsService() {
		UserDetails ashutosh = User
				.withUsername("ashutosh")
				.password("password")
				.roles("USER")
				.build();
		
		UserDetails anuja = User
				.withUsername("anuja")
				.password("password")
				.roles("USER")
				.build();
		
		return new InMemoryUserDetailsManager(ashutosh, anuja);
	}
	
//	@Bean UserDetailsService userDetailsService() {
//		return new JpaUserDetailsService();
//	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
}
