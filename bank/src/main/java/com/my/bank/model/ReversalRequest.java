package com.my.bank.model;

import java.sql.Timestamp;

public class ReversalRequest {
	private Integer reqId;
	private Integer transactionNo;
	private Timestamp reqDate;

	public ReversalRequest() {
	}

	public ReversalRequest(Integer reqId, Integer transactionNo, Timestamp reqDate) {
		this.reqId = reqId;
		this.transactionNo = transactionNo;
		this.reqDate = reqDate;
	}

	public Integer getReqId() {
		return reqId;
	}

	public void setReqId(Integer reqId) {
		this.reqId = reqId;
	}

	public Integer getTransactionNo() {
		return transactionNo;
	}

	public void setTransactionNo(Integer transactionNo) {
		this.transactionNo = transactionNo;
	}

	public Timestamp getReqDate() {
		return reqDate;
	}

	public void setReqDate(Timestamp reqDate) {
		this.reqDate = reqDate;
	}

	@Override
	public String toString() {
		return "ReversalRequest [reqId=" + reqId + ", transactionNo=" + transactionNo + ", reqDate=" + reqDate + "]";
	}

}
