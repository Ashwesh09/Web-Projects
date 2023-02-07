package com.my.bank.dao;

import java.sql.SQLException;
import java.util.List;

import com.my.bank.model.ReversalRequest;

public interface ReversalRequestDAO {

	public Boolean createRequest() throws SQLException;

	public List<ReversalRequest> showAll() throws SQLException;

	public Boolean deleteRequest(Integer reqId) throws SQLException;

	public Boolean approveRequest(Integer reqId) throws SQLException;

}
