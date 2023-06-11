package com.panther.workout.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="Goal")
public class Goal implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	//start date - local data
	@Column(nullable = false)
	@JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate startDate;
	
	//end date - local date
	@Column(nullable = false)
	@JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate endDate;
	
	//workout goal # - integer
	@Column(nullable = false)
	private int goalNum;
	

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn( name = "user_id", referencedColumnName = "id")
	private User user;


	public Goal() {
		super();
	}


	public Goal(Integer id, LocalDate startDate, LocalDate endDate, int goalNum, User user) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.goalNum = goalNum;
		this.user = user;
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


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "Goal [id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + ", goalNum=" + goalNum
				+ ", user=" + user + "]";
	}

	
	
	
	
	
	

}
