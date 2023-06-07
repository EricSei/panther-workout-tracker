package com.panther.workout.controller;

import com.panther.workout.model.Workout;
import com.panther.workout.repository.WorkoutRepository;
import com.panther.workout.service.UserService;
import com.panther.workout.service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class WorkoutController {

    @Autowired
    WorkoutService service;

    @Autowired
    WorkoutRepository repo;

    @GetMapping("/workout")
    public ResponseEntity<?> findAll() {
        List<Workout> workouts = service.getAllWorkouts();

        return ResponseEntity.status(200).body(workouts);
    }
}
