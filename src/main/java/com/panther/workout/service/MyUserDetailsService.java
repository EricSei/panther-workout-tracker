package com.panther.workout.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.panther.workout.model.User;
import com.panther.workout.repository.UserRepository;


@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> userfound = repo.findByUsername( username );
		
		// if we could not find the user, throw username not found exception
		if( userfound.isEmpty()) {
			throw new UsernameNotFoundException(username);
		}
		
		// the user details will be returned to spring security, and these details will be all the info needed to perform authentication and authorization
		
		return new MyUserDetails( userfound.get());
	}

}
