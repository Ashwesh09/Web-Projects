package com.springboot.my.org.crudapi.dao;

import java.sql.SQLException;
import java.util.List;

import com.springboot.my.org.crudapi.model.Worker;



/**
 * @author ASUS
 *
 */
public interface WorkerDAO {
	
	/**
	 * Create a Worker record
	 * 
	 * @param Worker Object
	 * @return 
	 * @throws SQLException 
	 */
	public Boolean create(Worker worker) throws SQLException;
	
	/**
	 * Fetches a Worker record corresponding to the Worker id
	 * 
	 * @param id Integer
	 * @return Worker
	 * @throws SQLException 
	 */

	public Worker getWorkerById(Integer id) throws SQLException;
	
	/**
	 * Lists down all Worker records
	 * 
	 * @return List<Worker>
	 * @throws SQLException 
	 */
	public List<Worker> getAllWorkers() throws SQLException;
	
	/**
	 * Updates a Worker's age based on their id
	 * 
	 * @param Worker Object
	 * @return 
	 * @throws SQLException 
	 */
	public Boolean update(Worker worker) throws SQLException;
	
	/**
	 * Deletes a Worker record based on their id
	 * 
	 * @param id IntegerS
	 * @return 
	 * @throws SQLException 
	 */
	public Boolean delete(Integer id) throws SQLException;
}