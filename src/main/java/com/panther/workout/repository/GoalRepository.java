package com.panther.workout.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.panther.workout.model.Goal;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Integer>{

}
