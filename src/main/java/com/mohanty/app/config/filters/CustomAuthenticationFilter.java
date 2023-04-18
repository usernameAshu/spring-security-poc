package com.mohanty.app.config.filters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.mohanty.app.config.authentication.CustomAuthenticationToken;

@Component
public class CustomAuthenticationFilter implements Filter {
	
	private final AuthenticationManager manager;

	public CustomAuthenticationFilter(AuthenticationManager manager) {
		this.manager = manager;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse)response;
		
		String authHeader = httpRequest.getHeader("Authorization");
		String authType = httpRequest.getAuthType() ;
		
		//these parameters should be fetched from Request
		String username = "ashutosh";
		String password = "password";
		GrantedAuthority authority = () -> "USER";
		List<GrantedAuthority> grantedRoles = new ArrayList<>();
		grantedRoles.add(authority);
		
		Authentication authentication = new CustomAuthenticationToken(username, password, grantedRoles);
		
		Authentication resultAuth = manager.authenticate(authentication);
		
		if(resultAuth.isAuthenticated()) {
			SecurityContextHolder.getContext().setAuthentication(authentication);
			chain.doFilter(httpRequest, httpResponse);
		} else {
			System.out.println("Authentication failed");
			throw new BadCredentialsException("Authentication Failed");
		}
		
	}

}
