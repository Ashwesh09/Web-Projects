package com.workers.jdbcexample.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workers.jdbcexample.util.GetTimeStamp;

@RestController
public class HomeController {
	@GetMapping("/")
	public String homePage() {
		return "Hello visitor!</br>Visiting time: "+GetTimeStamp.timeStamp();
	}
}