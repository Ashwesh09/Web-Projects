package com.my.bank.repository;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.my.bank.dao.CustomerDAO;
import com.my.bank.mapper.CustomerMapper;
import com.my.bank.model.Customer;

@Repository
public class CustomerRepository implements CustomerDAO {
	
	@Autowired
    JdbcTemplate jdbcTemplateObject;
	
	@Override
	public List<Customer> getCustomers() throws SQLException {
		String sql = "SELECT * FROM customers";
		return jdbcTemplateObject.query(
				sql, 
				new CustomerMapper()
				);
	}


	@Override
	public Customer createCustomer(Customer customer) throws SQLException {
		String sql = "INSERT INTO customers (`customerId`,`name`) VALUES(?,?)";
		jdbcTemplateObject.update(sql,customer.getCustomerId(),customer.getName());
		return new Customer();
	}

	@Override
	public Boolean deleteCustomerById(Integer custId) throws SQLException {
		String sql = "DELETE FROM customers WHERE customerId = ?";
		int res = jdbcTemplateObject.update(sql,custId);
		return res>0;
	}


	@SuppressWarnings("deprecation")
	@Override
	public Customer getCustomerById(Integer custId) throws SQLException {
		String sql = "SELECT * FROM customers WHERE customerId = ?";
		return jdbcTemplateObject.queryForObject(sql, new Object[] { custId }, new CustomerMapper());
	}	


}
