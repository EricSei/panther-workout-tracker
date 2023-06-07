package com.panther.workout.service;

import com.panther.workout.model.UserWorkout;
import com.panther.workout.repository.UserWorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserWorkoutService {
    @Autowired
    UserWorkoutRepository repo;

    public List<UserWorkout> getUserWorkoutsByUser(int id) {
        return null;
    }
}
