package com.panther.workout.controller;

import com.panther.workout.repository.UserWorkoutRepository;
import com.panther.workout.service.UserWorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/userworkout")
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserWorkoutController {

    @Autowired
    UserWorkoutService service;

    @Autowired
    UserWorkoutRepository repo;


}
