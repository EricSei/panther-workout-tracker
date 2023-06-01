package com.panther.workout;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class PantherWorkoutTrackerApp {
		
	public static void main(String[] args) {
		
		SpringApplication.run(PantherWorkoutTrackerApp.class, args);
		
		System.out.println("Panther App is running");
	}
}

