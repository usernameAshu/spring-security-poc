package com.mohanty.app.config;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {
	
	private UserDetailsService userDetailsService;
	private PasswordEncoder passwordEncoder;
	

	/**
	 * If authentication class is not supported , return <code>null</code>
	 * If authentication fails then throw {@link AuthenticationException}
	 * If authentication is successful then return a fully authenticated object i.e implementation of {@link Authentication}
	 */
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		if(!supports(authentication.getClass())) {
			return null;
		}
		
		String username = authentication.getName();
		String secret = String.valueOf(authentication.getCredentials());
		
		UserDetails userDetails = userDetailsService.loadUserByUsername(username);
		
		if (passwordEncoder.matches(secret, userDetails.getPassword())) {
			return new UsernamePasswordAuthenticationToken(username, secret, userDetails.getAuthorities());
		} else {
			System.out.println("Error in authentication!");
			throw new BadCredentialsException("Error in authentication!");
		}
	}

	/**
	 * Checks the authentication class type 
	 */
	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return UsernamePasswordAuthenticationToken.class.equals(authentication);
	}

}
