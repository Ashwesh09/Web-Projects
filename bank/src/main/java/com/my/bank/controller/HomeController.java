package com.my.bank.controller;

import java.sql.Timestamp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@GetMapping("/")
	public String home() {
		return "Hello visitor!<br>Visiting time:"+new Timestamp(System.currentTimeMillis());
	}
}
