package com.panther.workout.controller;



import java.util.List;
import java.util.Optional;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.panther.workout.model.Goal;
import com.panther.workout.model.User;
import com.panther.workout.repository.GoalRepository;
import com.panther.workout.service.UserService;

@RestController
@RequestMapping("/api")
public class GoalController {
	@Autowired
	private GoalRepository repo;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/goals")
	public List<Goal> getGoals(){
		return repo.findAll();
	}
	
	
	@GetMapping("/goals/{id}")
	public ResponseEntity<Goal> getGoalById(@PathVariable Integer id) {
		Optional<Goal> userGoal = repo.findById(id);
		if (userGoal.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.status(200).body(userGoal.get());
	}
	
	@PostMapping("/goals")
	public ResponseEntity<Goal> createGoal(@RequestBody Goal userGoal, HttpServletRequest request) throws Exception {
		Optional<User> found = userService.getAuthenticatedUserDetail(request);
		
		if(found.isPresent()) {
			User user = found.get();
			userGoal.setId(null);
			userGoal.setUser(user);
		
			Goal created = repo.save(userGoal);
			return new ResponseEntity<>(created, HttpStatus.CREATED);
		}
		return ResponseEntity.status(401).body(null);
		
	}
	
	//Get all the Goals of A user
	
	@PutMapping("/goals/{id}")
	public ResponseEntity<Goal> updateGoal(@PathVariable Integer id, @RequestBody Goal userGoal) {
		Optional<Goal> existingGoal = repo.findById(id);
		if (existingGoal.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Goal updated = repo.save(userGoal);
		return new ResponseEntity<Goal>(updated, HttpStatus.OK);
	}
	
	@DeleteMapping("/goals/{id}")
	public ResponseEntity<Void> deleteGoal(@PathVariable Integer id) {
		Goal existingGoal = repo.findById(id).orElse(null);
		if (existingGoal == null) {
			return ResponseEntity.notFound().build();
		}
		repo.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	
}
