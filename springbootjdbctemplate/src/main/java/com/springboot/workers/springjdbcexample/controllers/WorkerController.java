package com.springboot.workers.springjdbcexample.controllers;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

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
import com.springboot.workers.springjdbcexample.repository.WorkerRepository;




@RestController
@RequestMapping("/worker")
public class WorkerController {	
	
	@Resource(name="workerMySqlRepo")
	private WorkerRepository workerRepository;

	
	@GetMapping({"/worker/{id}"})
	public Worker showInfo(@PathVariable Integer id) {
		return workerRepository.getWorkerById(id);
	}
	
	@GetMapping("/all")
	public List<Worker> showAllWorkers() {
		return workerRepository.getAllWorkers();	
	}
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public String createWorker(@RequestBody Worker worker) {
		workerRepository.create(worker);
		return "Created worker "+ worker.getFirstName() + "'s record.";
	}
	@PatchMapping("/update/{id}")
	public String updateWorker(@PathVariable Integer id,@RequestBody Map<String,String> requestBody) {
		Worker worker = workerRepository.getWorkerById(id);
		worker.setEmail(requestBody.get("email"));
		workerRepository.update(worker);
		return "Updated worker "+ worker.getFirstName() + "'s record.<br/>With email: " + workerRepository.getWorkerById(id).getEmail();
	}
	
	@GetMapping("/delete/{id}")
	public String deleteWorker(@PathVariable Integer id) {
		workerRepository.delete(id);
		return "Deleted worker " + id + "'s record.";
	}
}