package com.mohanty.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
	
	private AuthenticationProvider authenticationProvider;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic();
		
		http.csrf().disable(); //Disabling to implement CSRF tokens 
		
		/**
		 * To allow the post call (add user) happen without authentication 
		 * All other endpoints are secured 
		 */
	    http.authorizeHttpRequests()
	    	.antMatchers("/user").permitAll()
	    	.anyRequest().authenticated();
	}
	

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider);
	}
	
}
