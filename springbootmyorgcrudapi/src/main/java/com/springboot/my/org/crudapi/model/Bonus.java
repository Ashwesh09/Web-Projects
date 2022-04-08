package com.springboot.my.org.crudapi.model;

import java.sql.Date;

public class Bonus {
	private Integer workerRefId;
	private Integer bonusAmount;
	private Date bonusDate;
	public Bonus(Integer workerRefId, Integer bonusAmount, Date bonusDate) {
		super();
		this.workerRefId = workerRefId;
		this.bonusAmount = bonusAmount;
		this.bonusDate = bonusDate;
	}
	public Bonus() {
	}
	public Integer getWorkerRefId() {
		return workerRefId;
	}
	public void setWorkerRefId(Integer workerRefId) {
		this.workerRefId = workerRefId;
	}
	public Integer getBonusAmount() {
		return bonusAmount;
	}
	public void setBonusAmount(Integer bonusAmount) {
		this.bonusAmount = bonusAmount;
	}
	public Date getBonusDate() {
		return bonusDate;
	}
	public void setBonusDate(Date bonusDate) {
		this.bonusDate = bonusDate;
	}
	@Override
	public String toString() {
		return "Bonus [workerRefId=" + workerRefId + ", bonusAmount=" + bonusAmount + ", bonusDate=" + bonusDate + "]";
	}

}
