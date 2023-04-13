package com.mohanty.app.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@Configuration
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
	
	
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

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.httpBasic();
		
		http.csrf().disable(); //Disabling to implement CSRF tokens 
		
		/**
		 * To allow the post call (add user) happen without authentication 
		 * All other enpoints are secured 
		 */
	    http.authorizeHttpRequests()
	    	.antMatchers("/user").permitAll()
	    	.anyRequest().authenticated();
	}
	
	
	
}
