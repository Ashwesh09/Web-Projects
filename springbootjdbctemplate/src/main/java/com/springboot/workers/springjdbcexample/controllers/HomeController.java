package com.springboot.workers.springjdbcexample.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.workers.springjdbcexample.helpers.GetTimeStamp;



@RestController
public class HomeController {
	@GetMapping("/")
	public String homePage() {
		return "Hello visitor!</br>Visiting time: "+GetTimeStamp.timeStamp();
	}
}