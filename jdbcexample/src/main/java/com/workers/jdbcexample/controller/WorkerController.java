package com.workers.jdbcexample.controller;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workers.jdbcexample.model.Worker;
import com.workers.jdbcexample.repository.WorkerRepository;


@RestController
@RequestMapping("/worker")
public class WorkerController {	
	
	@Autowired
	private WorkerRepository workerRepository;
	
	@GetMapping({"/showWorker"})
	public Worker showInfo() {
		try {
			return workerRepository.getWorkerById(5);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@GetMapping("/all/showWorkers")
	public List<Worker> showAllWorkers() {
		try {
			return workerRepository.getAllWorkers();
		} catch (SQLException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}
	
	@GetMapping("/createWorker")
	public String createWorker() {
		Worker worker1 = new Worker(21, "Ashwesh", "a.a@my_org.in");
		try {
			workerRepository.create(worker1);
			return "Created worker "+ worker1.getFirstName() + "'s record.";
		} catch (SQLException e) {
			e.printStackTrace();
			return "Unable to create worker with name "
					+ worker1.getFirstName()+ " because of error:</br>"+e.getMessage();		
		}
	}
	@GetMapping("/updateWorker")
	public String updateWorker() {
		Worker worker1 = new Worker(21, "Saitama", "s.s@my_org.in");
		try {
			workerRepository.update(worker1);
			return "Updated worker "+ worker1.getFirstName() + "'s record.";
		} catch (SQLException e) {
			e.printStackTrace();
			return "Unable to update worker with name "
					+ worker1.getFirstName()+ " because of error:</br>"+e.getMessage();		
		}
	}
	
	@GetMapping("/deleteWorker")
	public String deleteWorker() {
		try {
			workerRepository.delete(21);
			return "Deleted worker " + 21 + "'s record.";
		} catch (SQLException e) {
			e.printStackTrace();
			return "Unable to delete worker with name "
					+ 21+ " because of error</br>"+e.getMessage();		
		}
	}
}