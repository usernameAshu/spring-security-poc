package com.mohanty.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SecurityPocApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SecurityPocApplication.class, args);
	}
	
	@GetMapping("/")
	public String hello(Authentication authentication) {
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return "Hello "+ authentication.getName()+" !";
	}
	
	
}
