package com.nissan.service;

import java.util.List;

import com.nissan.model.Account;
import com.nissan.model.Customer;

public interface IAdminService {

	//Add a Customer
	Customer addCustomer(Customer customer);
	
	//Update a Customer
	Customer updateCustomer(Customer customer);
	
	//Disabling a Customer
	Customer disableCustomer(int customerId);
	
	//Display list of all Customers
	List<Customer> listCustomers();
	
	//Display Details of Specific Customer
	
}
