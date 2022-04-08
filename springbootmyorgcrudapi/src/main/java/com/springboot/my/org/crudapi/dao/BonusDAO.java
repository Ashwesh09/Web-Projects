package com.springboot.my.org.crudapi.dao;

import java.sql.SQLException;
import java.util.List;

import com.springboot.my.org.crudapi.model.Bonus;

/**
 * @author ASUS
 *
 */
public interface BonusDAO {
	
	/**
	 * Create a Bonus record
	 * 
	 * @param Bonus Object
	 * @return 
	 * @throws SQLException 
	 */
	public Boolean create(Bonus bonus) throws SQLException;
	
	/**
	 * Fetches a Bonus record corresponding to the Bonus id
	 * 
	 * @param id Integer
	 * @return Bonus
	 * @throws SQLException 
	 */

	public Bonus getBonusById(Integer id) throws SQLException;
	
	/**
	 * Lists down all Bonus records
	 * 
	 * @return List<Bonus>
	 * @throws SQLException 
	 */
	public List<Bonus> getAllBonuses() throws SQLException;
	
	/**
	 * Updates a Bonus's age based on their id
	 * 
	 * @param Bonus Object
	 * @return 
	 * @throws SQLException 
	 */
	public Boolean update(Bonus bonus) throws SQLException;
	
	/**
	 * Deletes a Bonus record based on their id
	 * 
	 * @param id IntegerS
	 * @return 
	 * @throws SQLException 
	 */
	public Boolean delete(Integer id) throws SQLException;
}