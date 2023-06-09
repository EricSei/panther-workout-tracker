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
	private Integer id;
	
	 @ManyToOne(fetch = FetchType.LAZY, optional = false)
	 @JoinColumn(name = "user_id", referencedColumnName = "id")
	 private User user;
	
	 @ManyToOne(fetch = FetchType.LAZY, optional = false)
	 @JoinColumn(name = "workout_id", referencedColumnName = "id")
	 private Workout workoutId;
	
	@Column(name = "workout_date")
	private Date workoutDate;
	
	@Column(name = "reps")
	private Integer reps;
	
	

	public UserWorkout() {
		super();
	}



	public UserWorkout(Integer id, User user, Workout workoutId, Date workoutDate, Integer reps) {
		super();
		this.id = id;
		this.user = user;
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



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public Workout getWorkoutId() {
		return workoutId;
	}



	public void setWorkoutId(Workout workoutId) {
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



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public String toString() {
		return "UserWorkout [id=" + id + ", user=" + user + ", workoutId=" + workoutId + ", workoutDate=" + workoutDate
				+ ", reps=" + reps + "]";
	}
	
	
	
	
   
}
