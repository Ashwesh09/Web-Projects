package com.my.bank.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.my.bank.model.Employee;

public class EmployeeMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee employee = new Employee();
		employee.setid(rs.getInt("id"));
		employee.setName(rs.getString("name"));
		employee.setbranchCode(rs.getString("branchCode"));
		return employee;
	}

}
