package com.myorg.services;


import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.myorg.dao.WorkerDAO;
import com.myorg.mappers.WorkerMapper;
import com.myorg.models.Worker;

public class WorkerJDBCTemplate implements WorkerDAO {
	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
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