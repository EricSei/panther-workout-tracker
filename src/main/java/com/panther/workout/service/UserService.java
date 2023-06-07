package com.panther.workout.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panther.workout.model.User;
import com.panther.workout.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepo;
	
	
	public User createUser(User user) {
		User created = userRepo.save(user);
		return created;
	}
}
