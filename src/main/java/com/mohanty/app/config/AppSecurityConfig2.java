package com.mohanty.app.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@Configuration
public class AppSecurityConfig2 {

	@Bean
	JdbcUserDetailsManager userDetailsService(DataSource datasource) {
		//InMemoryUserDetailsManager
		//JpaUserDetailsService
		return new JdbcUserDetailsManager(datasource);
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
