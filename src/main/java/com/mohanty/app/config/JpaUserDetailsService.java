package com.mohanty.app.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.mohanty.app.entity.Users;
import com.mohanty.app.repository.UsersRepository;

public class JpaUserDetailsService implements UserDetailsService {

	@Autowired
	private UsersRepository usersRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<Users> userDB = usersRepository.findUserByUsername(username);
		Users user = userDB.orElseThrow(() -> new UsernameNotFoundException("User not present in DB"));
		
		return new SecurityUser(user);
	}

}
