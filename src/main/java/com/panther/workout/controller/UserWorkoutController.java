package com.panther.workout.controller;

import com.panther.workout.model.User;
import com.panther.workout.model.UserWorkout;
import com.panther.workout.repository.UserWorkoutRepository;
import com.panther.workout.service.UserWorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserWorkoutController {

    @Autowired
    UserWorkoutService service;

    @Autowired
    UserWorkoutRepository repo;
    
    @PostMapping("/users/workouts")
	public ResponseEntity<?> updateUserWorkout(@RequestBody User user){
//		user.setId(null);
//		// use a password encoder to encode the password so it is not saved as plain text in the database
//		user.setPassword(encoder.encode(user.getPassword()));
//		
//		User created = repo.save(user);
//		
		return ResponseEntity.status(201).body(null);
	}
    
    @PostMapping("/userworkout")
    public ResponseEntity<?> createUserWorkout(@RequestBody UserWorkout userWorkout) {
        UserWorkout newUserWorkout = repo.save(userWorkout);
        return ResponseEntity.status(201).body(newUserWorkout);
    }


}
