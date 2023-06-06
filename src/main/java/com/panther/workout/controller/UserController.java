package com.panther.workout.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.panther.workout.model.User;
import com.panther.workout.service.UserService;

@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<?> createUser(@Valid @RequestBody User user) throws Exception{
		
		User created = userService.createUser(user);
		
		return ResponseEntity.status(201).body(created);
	}

}
