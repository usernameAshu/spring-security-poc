package com.mohanty.app.config;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.mohanty.app.entity.Users;
import com.mohanty.app.repository.UsersRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JpaUserDetailsService implements UserDetailsService {

	private final UsersRepository usersRepository;
	private final PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<Users> userDB = usersRepository.findUserByUsername(username);
		Users user = userDB.orElseThrow(() -> new UsernameNotFoundException("User not present in system"));
		
		return new SecurityUser(user, passwordEncoder);
	}

}
