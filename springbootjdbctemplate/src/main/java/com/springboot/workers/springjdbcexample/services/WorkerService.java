package com.springboot.workers.springjdbcexample.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.springboot.workers.springjdbcexample.models.Worker;
import com.springboot.workers.springjdbcexample.repository.WorkerRepository;

@Service
public class WorkerService {
	@Resource(name = "workerMySqlRepo")
	private WorkerRepository workerRepository;

	public Worker getWorker(Integer id) {
		return this.workerRepository.getWorkerById(id);

	}

	public List<Worker> getAllWorkers() {
		return this.workerRepository.getAllWorkers();

	}

	public Boolean createWorker(Worker worker) {
		return this.workerRepository.create(worker);
	}

	public Boolean updateWorkerEmailId( String email, Integer id) {
		return this.workerRepository.updateWorkerByEmail(id,email);
	}

	public Boolean deleteWorker(Integer id) {
		return this.workerRepository.delete(id);
	}
}