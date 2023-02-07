
package com.my.bank.model;

public class Customer {
	private String name;
	private Address address;
	private Integer customerId;

	public Customer() {
		super();
	}

	public Customer(String name, Address address, Integer customerId) {
		super();
		this.name = name;
		this.address = address;
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

}
