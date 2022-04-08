package com.springboot.my.org.crudapi.controller;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.my.org.crudapi.model.Worker;
import com.springboot.my.org.crudapi.service.WorkerService;


@RestController
@RequestMapping("/worker")
public class WorkerController {	
	
	@Autowired
	private WorkerService workerService;
	
	private static final Logger log = LoggerFactory.getLogger(WorkerController.class);

	
	@GetMapping({"/worker/{id}"})
	public Worker showInfo(@PathVariable Integer id) {
		return workerService.getWorker(id);
	}
	
	@GetMapping({"/showWorker"})
	public Worker showWorker(@RequestParam Integer workerId) {
		return workerService.getWorker(workerId);
	}
	
	@GetMapping("/all")
	public List<Worker> showAllWorkers() {
		return workerService.getAllWorkers();	
	}
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public Boolean createWorker(@RequestBody Worker worker) {
		log.info("Worker created.");
		return workerService.createWorker(worker);
	}

	@PostMapping(path = "/createWorker", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE,MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(HttpStatus.CREATED)
	public Boolean createWorkerByForm(@RequestParam MultiValueMap<String, String> pm) {
		Worker w = new Worker();
		w.setWorkerId(Integer.parseInt(pm.getFirst("workerId")));
		w.setFirstName(pm.getFirst("firstName"));
		w.setLastName(pm.getFirst("lastName"));
		w.setSalary(Integer.parseInt(pm.getFirst("salary")));
		Date date = Date.valueOf(pm.getFirst("joiningDate"));
		w.setJoiningDate(date);
		w.setDepartment(pm.getFirst("department"));
		w.setEmail(pm.getFirst("email"));
		w.setPassword(pm.getFirst("password"));
		log.info("Worker created.");

		return workerService.createWorker(w);
	}
	
	@GetMapping("/delete/{id}")
	public Boolean deleteWorker(@PathVariable Integer id) {
		return workerService.deleteWorker(id);
	}
	@PostMapping(path="/deleteForm" ,
			consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String deleteWorkerForm(@RequestParam Integer workerId) {
		workerService.deleteWorker(workerId);
		return "Deleted Worker No:"+ workerId;
	}
	
	@PatchMapping("/update/{id}")
	public Boolean updateWorker(@PathVariable Integer id,@RequestBody Map<String,String> requestBody) {
		String email = requestBody.get("email");
		return workerService.updateWorkerEmailId(email,id);
	}
	
}