package com.springboot.my.org.crudapi.service;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.my.org.crudapi.model.Worker;
import com.springboot.my.org.crudapi.repository.WorkerRepository;



@Service
public class WorkerService {
	@Autowired
	private WorkerRepository workerRepository;

	public Worker getWorker(Integer id) {
		try {
			return this.workerRepository.getWorkerById(id);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	public List<Worker> getAllWorkers() {
		try {
			return this.workerRepository.getAllWorkers();
		} catch (SQLException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	public Boolean createWorker(Worker worker) {
		try {
			return this.workerRepository.create(worker);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}


	public Boolean deleteWorker(Integer id) {
		try {
			return this.workerRepository.delete(id);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Boolean updateWorkerEmailId( String email, Integer id) {
		Worker w;
		try {
			w = workerRepository.getWorkerById(id);
			w.setEmail(email);
			return this.workerRepository.update(w);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		
	}
}