package com.panther.workout.controller;

import java.util.List;
import java.util.Optional;

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
import com.panther.workout.repository.GoalRepository;

@RestController
@RequestMapping("/api")
public class GoalController {
	@Autowired
	private GoalRepository repo;
	
	@GetMapping("/userGoals")
	public List<Goal> getAllUserGoals(){
		return repo.findAll();
	}
	
	
	@GetMapping("/userGoals/{id}")
	public ResponseEntity<Goal> getGoalById(@PathVariable Integer id) {
		Optional<Goal> userGoal = repo.findById(id);
		if (userGoal.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.status(200).body(userGoal.get());
	}
	
	@PostMapping("/userGoals")
	public ResponseEntity<Goal> createGoal(@RequestBody Goal userGoal) {
		Goal created = repo.save(userGoal);
		return new ResponseEntity<>(created, HttpStatus.CREATED);
	}
	
	@PutMapping("/userGoals/{id}")
	public ResponseEntity<Goal> updateGoal(@PathVariable Integer id, @RequestBody Goal userGoal) {
		Optional<Goal> existingGoal = repo.findById(id);
		if (existingGoal.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Goal updated = repo.save(userGoal);
		return new ResponseEntity<Goal>(updated, HttpStatus.OK);
	}
	
	@DeleteMapping("/userGoals/{id}")
	public ResponseEntity<Void> deleteGoal(@PathVariable Integer id) {
		Goal existingGoal = repo.findById(id).orElse(null);
		if (existingGoal == null) {
			return ResponseEntity.notFound().build();
		}
		repo.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	
}
