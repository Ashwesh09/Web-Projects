package com.springboot.workers.springjdbcexample.repository;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.workers.springjdbcexample.dao.WorkerDAO;
import com.springboot.workers.springjdbcexample.mappers.WorkerMapper;
import com.springboot.workers.springjdbcexample.models.Worker;


@Repository("workerMySqlRepo")
public class WorkerRepository implements WorkerDAO {

	@Autowired
	JdbcTemplate jdbcTemplateObject;
	
	public void create(Worker w) {
		String sql = "INSERT INTO worker VALUES( ? , ? , ? , ? , ? , ? , ? );";
                
		
		jdbcTemplateObject.update(sql, 
				w.getWorkerId(),
                w.getFirstName(),
                w.getLastName(), 
                w.getSalary(), 
                w.getJoiningDate(), 
                w.getDepartment(), 
                w.getEmail());
		
		System.out.println("Worker " + w.getFirstName() + "'s record inserted successfully");

	}
	
	@SuppressWarnings("deprecation")
	public Worker getWorkerById(Integer id) {
		String sql = "SELECT * FROM Worker WHERE worker_id = ?";
		
		return jdbcTemplateObject.queryForObject(
				sql, 
				new Object[] {id}, 
				new WorkerMapper()
				);
	}
	
	public List<Worker> getAllWorkers() {
		String sql = "SELECT * FROM Worker";
		
		return jdbcTemplateObject.query(
				sql, 
				new WorkerMapper()
				);
	}
	
	public void update(Worker w) {
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
		jdbcTemplateObject.update(sql, 
				w.getWorkerId(),
                w.getFirstName(),
                w.getLastName(), 
                w.getSalary(), 
                w.getJoiningDate(), 
                w.getDepartment(), 
                w.getEmail(),
				w.getWorkerId());
		System.out.println("Record #" + w.getWorkerId() + " updated!");
	}
	
	public void delete(Integer id) {
		String sql = "DELETE FROM Worker WHERE worker_id = ?";
		jdbcTemplateObject.update(sql, id);
		System.out.println("Record #" + id + " deleted");
	}
}