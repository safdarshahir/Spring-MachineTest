package com.nissan.model;

import org.springframework.beans.factory.annotation.Autowired;

public class CustomerDTO {

	@Autowired
	Customer customer;
	
	@Autowired
	Account account;
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
	
	
}
