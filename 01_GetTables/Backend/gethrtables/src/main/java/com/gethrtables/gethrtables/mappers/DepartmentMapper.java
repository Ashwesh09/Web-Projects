package com.gethrtables.gethrtables.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gethrtables.gethrtables.models.Department;


public class DepartmentMapper implements RowMapper<Department> {
	public Department mapRow(ResultSet result, int rowNum) throws SQLException {
		Department department = new Department();
		department.setDEPARTMENT_ID(result.getInt("Department_ID"));
		department.setDEPARTMENT_NAME(result.getString("Department_NAME"));
		department.setManager_ID(result.getInt("MANAGER_ID"));
		department.setLocation_ID(result.getInt("LOCATION_ID"));
		return department;
	}
}

