package com.my.bank.dao;

import java.sql.SQLException;
import java.util.List;

import com.my.bank.model.Customer;

public interface CustomerDAO {

	public Customer getCustomerById(Integer custId) throws SQLException;

	public Customer createCustomer(Customer customer) throws SQLException;

	public Boolean deleteCustomerById(Integer custId) throws SQLException;

	List<Customer> getCustomers() throws SQLException;
}
