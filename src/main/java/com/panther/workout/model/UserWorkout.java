package com.panther.workout.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "User_Workout")
public class UserWorkout implements Serializable {

    private static final long serialVersionUID = 49218008973560624L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "User_id")
  Integer userId;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "Workout_id")
  Integer workoutId;

    @Column(name = "workout_date")
    Date workoutDate;

    @Column(name = "reps")
    Integer reps;

    public UserWorkout(Integer id, Integer userId, Integer workoutId, Date workoutDate, Integer reps) {
        this.id = id;
        this.userId = userId;
        this.workoutId = workoutId;
        this.workoutDate = workoutDate;
        this.reps = reps;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getWorkoutId() {
        return workoutId;
    }

    public void setWorkoutId(Integer workoutId) {
        this.workoutId = workoutId;
    }

    public Date getWorkoutDate() {
        return workoutDate;
    }

    public void setWorkoutDate(Date workoutDate) {
        this.workoutDate = workoutDate;
    }

    public Integer getReps() {
        return reps;
    }

    public void setReps(Integer reps) {
        this.reps = reps;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserWorkout that = (UserWorkout) o;
        return Objects.equals(id, that.id) && Objects.equals(userId, that.userId) && Objects.equals(workoutId, that.workoutId) && Objects.equals(workoutDate, that.workoutDate) && Objects.equals(reps, that.reps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, workoutId, workoutDate, reps);
    }

    @Override
    public String toString() {
        return "UserWorkout{" +
                "id=" + id +
                ", userId=" + userId +
                ", workoutId=" + workoutId +
                ", workoutDate=" + workoutDate +
                ", reps=" + reps +
                '}';
    }
}
