package com.springboot.my.org.crudapi.dao;

import java.sql.SQLException;
import java.util.List;

import com.springboot.my.org.crudapi.model.Title;

/**
 * @author ASUS
 *
 */
public interface TitleDAO {
	
	/**
	 * Create a Title record
	 * 
	 * @param Title Object
	 * @return 
	 * @throws SQLException 
	 */
	public Boolean create(Title title) throws SQLException;
	
	/**
	 * Fetches a Title record corresponding to the Title id
	 * 
	 * @param id Integer
	 * @return Title
	 * @throws SQLException 
	 */

	public Title getTitleById(Integer id) throws SQLException;
	
	/**
	 * Lists down all Title records
	 * 
	 * @return List<Title>
	 * @throws SQLException 
	 */
	public List<Title> getAllTitles() throws SQLException;
	
	/**
	 * Updates a Title's age based on their id
	 * 
	 * @param Title Object
	 * @return 
	 * @throws SQLException 
	 */
	public Boolean update(Title title) throws SQLException;
	
	/**
	 * Deletes a Title record based on their id
	 * 
	 * @param id IntegerS
	 * @return 
	 * @throws SQLException 
	 */
	public Boolean delete(Integer id) throws SQLException;
}
