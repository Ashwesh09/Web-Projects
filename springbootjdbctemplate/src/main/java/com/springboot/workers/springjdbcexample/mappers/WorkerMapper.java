package com.springboot.workers.springjdbcexample.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springboot.workers.springjdbcexample.models.Worker;


public class WorkerMapper implements RowMapper<Worker> {
	public Worker mapRow(ResultSet result, int rowNum) throws SQLException {
		Worker worker = new Worker();
		worker.setWorkerId(result.getInt("WORKER_ID"));
		worker.setFirstName(result.getString("FIRST_NAME"));
		worker.setLastName(result.getString("LAST_NAME"));
		worker.setSalary(result.getInt("SALARY"));
		worker.setJoiningDate(result.getDate("JOINING_DATE"));
		worker.setDepartment(result.getString("DEPARTMENT"));
		worker.setEmail(result.getString("email"));
		worker.setPassword(result.getString("password"));
		return worker;
	}
}