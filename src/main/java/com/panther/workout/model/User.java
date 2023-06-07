package com.panther.workout.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="User")
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY  )
	private Integer id;
	
	@Column(unique=true, nullable=false)
	private String username;
	
	@Column(nullable = false)
	@NotNull
	private String password;
	
	@Column()
	private int rewardPoints;

	public User() {
		super();
	}

	public User(Integer id, String username, @NotNull String password, int rewardPoints) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.rewardPoints = rewardPoints;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRewardPoints() {
		return rewardPoints;
	}

	public void setRewardPoints(int rewardPoints) {
		this.rewardPoints = rewardPoints;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", rewardPoints=" + rewardPoints
				+ "]";
	}
	
	
	
	

}
