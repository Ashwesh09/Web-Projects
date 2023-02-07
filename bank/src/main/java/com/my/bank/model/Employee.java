package com.my.bank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer emp_id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "branchCode")
	private String branchCode;
		
	
	public Employee() {
		
	}


	public Employee(String name, String branchCode) {
		super();
		this.name = name;
		this.branchCode = branchCode;
	}


	public Integer getid() {
		return emp_id;
	}


	public void setid(Integer id) {
		this.emp_id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getbranchCode() {
		return branchCode;
	}


	public void setbranchCode(String branchCode) {
		this.branchCode = branchCode;
	}


	@Override
	public String toString() {
		return "Employee [id=" + emp_id + ", name=" + name + ", branchCode=" + branchCode + "]";
	}
	
	
	
	
	
}