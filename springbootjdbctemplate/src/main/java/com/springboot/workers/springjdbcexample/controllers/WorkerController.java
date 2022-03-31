package com.springboot.workers.springjdbcexample.controllers;


import java.util.List;

import javax.annotation.Resource;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.workers.springjdbcexample.models.Worker;
import com.springboot.workers.springjdbcexample.repository.WorkerRepository;




@RestController
@RequestMapping("/worker")
public class WorkerController {	
	
	@Resource(name="workerMySqlRepo")
	private WorkerRepository workerRepository;

	
	@GetMapping({"/showWorker"})
	public Worker showInfo() {
		return workerRepository.getWorkerById(5);
	}
	
	@GetMapping("/all/showWorkers")
	public List<Worker> showAllWorkers() {
		return workerRepository.getAllWorkers();
	}
	
	@GetMapping("/createWorker")
	public String createWorker() {
		Worker worker1 = new Worker(21, "Ashwesh", "a.a@my_org.in");
		workerRepository.create(worker1);
		return "Created worker "+ worker1.getFirstName() + "'s record.";
	}
	@GetMapping("/updateWorker")
	public String updateWorker() {
		Worker worker1 = new Worker(21, "Saitama", "s.s@my_org.in");
		workerRepository.update(worker1);
		return "Updated worker "+ worker1.getFirstName() + "'s record.";
	}
	
	@GetMapping("/deleteWorker")
	public String deleteWorker() {
		workerRepository.delete(21);
		return "Deleted worker " + 21 + "'s record.";
	}
}