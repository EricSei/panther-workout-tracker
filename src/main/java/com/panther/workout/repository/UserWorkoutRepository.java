package com.panther.workout.repository;

import com.panther.workout.model.UserWorkout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserWorkoutRepository extends JpaRepository<UserWorkout, Integer> {
}
