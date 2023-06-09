package com.panther.workout.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.panther.workout.model.User;
import com.panther.workout.repository.UserRepository;
import com.panther.workout.service.UserService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
	
	@Autowired
	UserRepository repo;
	
	@Autowired
	PasswordEncoder encoder;
	
	
	@Autowired
	UserService userService;
	
//	@PostMapping("/register")
//	public ResponseEntity<?> createUser(@Valid @RequestBody User user) throws Exception{
//		
//		User created = userService.createUser(user);
//		
//		return ResponseEntity.status(201).body(created);
//		
//	}
	
	@GetMapping("/user/authenticated/details")
	public ResponseEntity<?> getUserDetails(HttpServletRequest request) throws Exception{
		
		
		Optional<User> found = userService.getAuthenticatedUserDetail(request);
		
		if(found == null) {
			return ResponseEntity
					.status(401)
					.body("error :" + "Unauthorized. :(");
		}
		
		return ResponseEntity
				.status(201)
				.body(found.get());
		
	}
	
	@PostMapping("/users")
	public ResponseEntity<?> authenticate(@RequestBody User user){
		user.setId(null);
		// use a password encoder to encode the password so it is not saved as plain text in the database
		user.setPassword(encoder.encode(user.getPassword()));
		
		User created = repo.save(user);
		
		return ResponseEntity.status(201).body(created);
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<?> deleteBookById(@PathVariable int id){
		
		if(userService.deleteUserById(id)) {
			return ResponseEntity
					.status(201)
					.body(id + "was deleted");
		}
		return ResponseEntity
				.status(401)
				.body(id + "was not found, or can't be deleted.");
	}

}
