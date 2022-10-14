package com.nissan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.model.Account;
import com.nissan.model.Customer;
import com.nissan.service.IAdminService;

@CrossOrigin
@RestController
@RequestMapping("api/")
public class AdminController {

	@Autowired
	IAdminService adminService;
	
	@PostMapping("add")
	public Customer addCustomer(@RequestBody Customer customer) {
//	    Customer customer = cst;
	    for (Account account : customer.getAccount()) {
	    	account.setCustomer(customer);
	    	System.out.println(account.getCustomer());
		}
		return adminService.addCustomer(customer);
	}
	
	@PutMapping("update")
	public Customer updateCustomer(@RequestBody Customer customer) {
//	    Customer customer = cst;
		for (Account account : customer.getAccount()) {
			account.setCustomer(customer);
			System.out.println(account.getCustomer());
		}
		return adminService.addCustomer(customer);
	}
	
	
	@GetMapping("list")
	public List<Customer> listCustomers(){
		return adminService.listCustomers();
	}
	
	@PutMapping("disable/{customerId}")
	public Customer disableCustomer(@PathVariable int customerId) {
		return adminService.disableCustomer(customerId);
	}
}
