package com.myorg.dao;


import java.util.List;

import javax.sql.DataSource;

import com.myorg.models.Worker;

public interface WorkerDAO {
	/**
	 * It is used to initialize the DB connection
	 * 
	 * @param ds DataSource
	 */
	public void setDataSource(DataSource dataSource);
	
	/**
	 * Create a Worker record
	 * 
	 * @param name String
	 * @param age Integer
	 */

	public void create(Worker worker);
	
	/**
	 * Fetches a Worker record corresponding to the Worker id
	 * 
	 * @param id Integer
	 * @return Worker
	 */

	public Worker getWorkerById(Integer id);
	
	/**
	 * Lists down all Worker records
	 * 
	 * @return List<Worker>
	 */
	public List<Worker> getAllWorkers();
	
	/**
	 * Updates a Worker's age based on their id
	 * 
	 * @param id Integer
	 * @param age Integer
	 */
	public void update(Worker worker);
	
	/**
	 * Deletes a Worker record based on their id
	 * 
	 * @param id Integer
	 */
	public void delete(Integer id);
}
