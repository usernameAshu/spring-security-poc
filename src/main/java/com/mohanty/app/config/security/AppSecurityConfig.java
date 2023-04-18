package com.mohanty.app.config.security;

import javax.servlet.Filter;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.mohanty.app.config.authenticationProvider.CustomAuthenticationProvider;
import com.mohanty.app.config.filters.CustomAuthenticationFilter;

import lombok.AllArgsConstructor;

@Configuration
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
	
	private CustomAuthenticationProvider authenticationProvider;
	private CustomAuthenticationFilter filter;
	
	public AppSecurityConfig(@Lazy CustomAuthenticationProvider authenticationProvider, @Lazy CustomAuthenticationFilter filter) {
		this.authenticationProvider = authenticationProvider;
		this.filter = filter;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.addFilterAt(filter, BasicAuthenticationFilter.class);
		
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

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}
	
	/**
	 * Using a manager instead of a User-details-service helps to manage the user
	 * with create, update, delete functionalities
	 * @param datasource
	 * @return
	 */
	@Bean
	JdbcUserDetailsManager userDetailsService(DataSource datasource) {
		return new JdbcUserDetailsManager(datasource);
	}
	
//	@Bean
//	CustomUserDetailsService userDetailsService(DataSource datasource) {
//		//InMemoryUserDetailsManager
//		//CustomUserDetailsService
//		return new CustomUserDetailsService(repository, passwordEncoder());
//	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
