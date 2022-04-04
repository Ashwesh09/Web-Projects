package com.springboot.workers.springjdbcexample.controllers;


import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.workers.springjdbcexample.models.Worker;
import com.springboot.workers.springjdbcexample.services.WorkerService;




@RestController
@RequestMapping("/worker")
public class WorkerController {	
	
	@Autowired
	private WorkerService workerService;

	
	@GetMapping({"/worker/{id}"})
	public Worker showInfo(@PathVariable Integer id) {
		return workerService.getWorker(id);
	}
	
	@GetMapping("/all")
	public List<Worker> showAllWorkers() {
		return workerService.getAllWorkers();	
	}
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public Boolean createWorker(@RequestBody Worker worker) {
		return workerService.createWorker(worker);
	}
	@PatchMapping("/update/{id}")
	public Boolean updateWorker(@PathVariable Integer id,@RequestBody Map<String,String> requestBody) {
		String email = requestBody.get("email");
		return workerService.updateWorkerEmailId(email,id);
	}
	
	@GetMapping("/delete/{id}")
	public Boolean deleteWorker(@PathVariable Integer id) {
		return workerService.deleteWorker(id);
	}
}