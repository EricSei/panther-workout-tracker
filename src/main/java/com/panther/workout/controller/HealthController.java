package com.panther.workout.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
	
	@GetMapping("/api/health")
	public String getHealth() {
		return "Hello from Panther";
	}
	
	@GetMapping("/api/hello")
	public String getHello() {
		return "Hello from Panther";
	}
}
