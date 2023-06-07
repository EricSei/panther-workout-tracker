package com.panther.workout.model;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;



@Entity
public class Goal implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	//start date - local data
	@Column(nullable = false)
    private LocalDate startDate;
	
	//end date - local date
	@Column(nullable = false)
    private LocalDate endDate;
	
	//workout goal # - integer
	@Column(nullable = false)
	private int goalNum;
	

	//user id relationship with goals

	@JsonIgnore
	@ManyToOne
	@JoinColumn( name = "user_id", referencedColumnName = "id")
	private User user_id; //need to implement the User model


	public Goal() {
	}


	public Goal(Integer id, LocalDate startDate, LocalDate endDate, int goalNum, User user_id) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.goalNum = goalNum;
		this.user_id = user_id;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public LocalDate getStartDate() {
		return startDate;
	}


	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}


	public LocalDate getEndDate() {
		return endDate;
	}


	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}


	public int getGoalNum() {
		return goalNum;
	}


	public void setGoalNum(int goalNum) {
		this.goalNum = goalNum;
	}


	public User getUser_id() {
		return user_id;
	}


	public void setUser_id(User user_id) {
		this.user_id = user_id;
	}


	@Override
	public String toString() {
		return "Goal [id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + ", goalNum=" + goalNum + "]";
	}
	
	
	
	
	

}
