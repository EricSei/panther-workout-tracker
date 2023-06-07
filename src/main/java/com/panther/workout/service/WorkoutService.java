package com.panther.workout.service;

import com.panther.workout.model.Workout;
import com.panther.workout.repository.UserRepository;
import com.panther.workout.repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutService {
    @Autowired
    WorkoutRepository repo;

    public List<Workout> getAllWorkouts() {
        return repo.findAll();
    }

}
