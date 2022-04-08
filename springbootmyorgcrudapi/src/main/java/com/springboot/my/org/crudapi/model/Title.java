package com.springboot.my.org.crudapi.model;

import java.sql.Date;

public class Title {
	private Integer workerRefId;
	private String workerTitle;
	private Date affectedFrom;
	
	
	
	public Title(Integer workerRefId, String workerTitle, Date affectedFrom) {
		super();
		this.workerRefId = workerRefId;
		this.workerTitle = workerTitle;
		this.affectedFrom = affectedFrom;
	}
	public Title() {
	}
	public Integer getWorkerRefId() {
		return workerRefId;
	}
	public void setWorkerRefId(Integer workerRefId) {
		this.workerRefId = workerRefId;
	}
	public String getWorkerTitle() {
		return workerTitle;
	}
	public void setWorkerTitle(String workerTitle) {
		this.workerTitle = workerTitle;
	}
	public Date getAffectedFrom() {
		return affectedFrom;
	}
	public void setAffectedFrom(Date affectedFrom) {
		this.affectedFrom = affectedFrom;
	}
	@Override
	public String toString() {
		return "Title [workerRefId=" + workerRefId + ", workerTitle=" + workerTitle + ", affectedFrom=" + affectedFrom
				+ "]";
	}
	
	
}
