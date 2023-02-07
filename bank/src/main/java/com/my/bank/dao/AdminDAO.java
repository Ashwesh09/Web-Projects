package com.my.bank.dao;

import java.sql.SQLException;
import java.util.List;

import com.my.bank.model.Admin;
import com.my.bank.model.Customer;
import com.my.bank.model.Transaction;

public interface AdminDAO {
	public Admin getAdminById(Integer adminId) throws SQLException;

	public List<Transaction> showTransactions() throws SQLException;

	public List<Customer> showCustomers() throws SQLException;

}
