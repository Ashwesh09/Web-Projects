package com.my.bank.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.my.bank.model.ReversalRequest;

public class ReversalRequestMapper implements RowMapper<ReversalRequest> {

	@Override
	public ReversalRequest mapRow(ResultSet rs, int rowNum) throws SQLException {
		ReversalRequest reversalRequest = new ReversalRequest();
		reversalRequest.setReqId(rs.getInt("reqId"));
		reversalRequest.setTransactionNo(rs.getInt("transactionNo"));
		reversalRequest.setReqDate(rs.getTimestamp("reqDate"));
		return reversalRequest;
	}

}