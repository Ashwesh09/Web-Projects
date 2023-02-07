package com.gethrtables.gethrtables.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gethrtables.gethrtables.dao.DepartmentDAO;
import com.gethrtables.gethrtables.mappers.DepartmentMapper;
import com.gethrtables.gethrtables.models.Department;

@Repository("departmentsMySqlRepo")
public class DepartmentRepository implements DepartmentDAO {

    @Autowired
	JdbcTemplate jdbcTemplateObject;
	
	private static final Logger log = LoggerFactory.getLogger(DepartmentRepository.class);

    public List<Department> getAllDepartments() {
		String sql = "SELECT `DEPARTMENT_ID`,`DEPARTMENT_NAME`,`MANAGER_ID`,`LOCATION_ID` FROM departments;";
		log.info("Hello this is a logger in getAllDeparmtents opertion.");
		return jdbcTemplateObject.query(
				sql, 
				new DepartmentMapper()
				);
	}
}
