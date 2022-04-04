package com.springboot.workers.springjdbcexample.repository;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.springboot.workers.springjdbcexample.dao.WorkerDAO;
import com.springboot.workers.springjdbcexample.mappers.WorkerMapper;
import com.springboot.workers.springjdbcexample.models.Worker;


@Repository("workerMySqlRepo")
public class WorkerRepository implements WorkerDAO {

	@Autowired
	JdbcTemplate jdbcTemplateObject;
	
	private static final Logger log = LoggerFactory.getLogger(WorkerRepository.class);

	
	public Boolean create(Worker w) {
		String sql = "INSERT INTO worker VALUES( ? , ? , ? , ? , ? , ? , ? );";
                
		
		int res = jdbcTemplateObject.update(sql, 
				w.getWorkerId(),
                w.getFirstName(),
                w.getLastName(), 
                w.getSalary(), 
                w.getJoiningDate(), 
                w.getDepartment(), 
                w.getEmail());
		
		System.out.println("Worker " + w.getFirstName() + "'s record inserted successfully");
		log.info("Hello this is a logger in create opertion.");
		return res == 1;

	}
	
	@SuppressWarnings("deprecation")
	public Worker getWorkerById(Integer id) {
		String sql = "SELECT * FROM Worker WHERE worker_id = ?";
		log.info("Hello this is a logger in getWorkerById opertion.");
		return jdbcTemplateObject.queryForObject(
				sql, 
				new Object[] {id}, 
				new WorkerMapper()
				);
	}
	
	public List<Worker> getAllWorkers() {
		String sql = "SELECT * FROM Worker";
		log.info("Hello this is a logger in getAllWorker opertion.");
		return jdbcTemplateObject.query(
				sql, 
				new WorkerMapper()
				);
	}
	
	public Boolean update(Worker w) {	
		String sql = """
                UPDATE worker SET 
                worker_id = ?, 
                first_name = ? , 
                last_name = ? , 
                salary = ?, 
                joining_date =  ? , 
                department = ? ,
                email = ?  
                WHERE worker_id = ? """;
		System.out.println("Record #" + w.getWorkerId() + " updated!");
		log.info("Hello this is a logger in update opertion.");
		int res = jdbcTemplateObject.update(sql, 
				w.getWorkerId(),
				w.getFirstName(),
				w.getLastName(), 
				w.getSalary(), 
				w.getJoiningDate(), 
				w.getDepartment(), 
				w.getEmail(),
				w.getWorkerId());
		return res == 1;
				
	}
	
	public Boolean delete(Integer id) {
		String sql = "DELETE FROM Worker WHERE worker_id = ?";
		int res =jdbcTemplateObject.update(sql, id);
		System.out.println("Record #" + id + " deleted");
		log.info("Hello this is a logger in delete opertion.");
		return res == 1;
	}

	@Override
	public Boolean updateWorkerByEmail(Integer id, String email) {
		Worker w = this.getWorkerById(id);
		w.setEmail(email);
		String sql = """
                UPDATE worker SET 
                worker_id = ?, 
                first_name = ? , 
                last_name = ? , 
                salary = ?, 
                joining_date =  ? , 
                department = ? ,
                email = ?  
                WHERE worker_id = ? """;
		System.out.println("Record #" + w.getWorkerId() + " updated!");
		log.info("Hello this is a logger in update opertion.");
		int res = jdbcTemplateObject.update(sql, 
				w.getWorkerId(),
				w.getFirstName(),
				w.getLastName(), 
				w.getSalary(), 
				w.getJoiningDate(), 
				w.getDepartment(), 
				w.getEmail(),
				w.getWorkerId());
		return res == 1;
	}
}