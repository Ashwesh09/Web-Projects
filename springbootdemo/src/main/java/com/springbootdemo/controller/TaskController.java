package com.springbootdemo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {
	@GetMapping("/task")
	public String index() {
		return "Task demonstration";
	}
	
	@GetMapping({"/task/showMyInfo"})
	public String showInfo() {
		return "Name : Ashwesh <br/>City: Nagpur<br/>State: Maharashtra<br/>Dream Job: SDE";
	}
	
	@GetMapping("/task/showMyHobbies")
	public List<String> showHobbbies() {
		return List.of("Programming","Playing Guitar","Badminton");
	}
}
