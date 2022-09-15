package com.Jvnyor.bds04.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Jvnyor.bds04.entities.User;
import com.Jvnyor.bds04.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService {

	private static Logger log = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repository.findByEmail(username);
		if (user == null) {
			log.error("User not found: {}", username);
			throw new UsernameNotFoundException("Email not found");
		}
		log.info("User found: {}", username);
		return user;
	}

}
