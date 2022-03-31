package com.springactuator.springactuatordemo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springactuator.springactuatordemo.models.Worker;

@RestController
@RequestMapping("/worker")
public class WorkerController {	
	@GetMapping({"showWorker"})
	public Worker showInfo() {
		return new Worker(21, "Ashwesh", "a.a@my_org.in");
	}
	
	@GetMapping("/all/showWorkers")
	public List<Worker> showAllWorkers() {
		return List.of(new Worker(21,"Ashwesh","a.a@my_org.com"),
				new Worker(22,"Saitama","s.s@my_org.com"),
				new Worker(21,"Genos","g.g@my_org.com"));
	}
}
