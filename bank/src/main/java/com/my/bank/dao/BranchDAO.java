package com.my.bank.dao;

import java.sql.SQLException;
import java.util.List;

import com.my.bank.model.Branch;
import com.my.bank.model.Customer;
import com.my.bank.model.Transaction;

public interface BranchDAO {
	public Boolean createBranch(Branch branch) throws SQLException;

	public Branch viewDetailsByBranchCode(String branchCode) throws SQLException;
	
	public List<Transaction> showTransactions(String branchCode) throws SQLException;
	
	public List<Customer> showCustomers(String branchCode) throws SQLException;
	
	public Boolean updateByBranchCode(String branchCode) throws SQLException;

	public Boolean deleteByBranchCode(String branchCode) throws SQLException;
}
