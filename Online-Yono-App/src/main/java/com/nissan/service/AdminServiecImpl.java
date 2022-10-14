package com.nissan.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.model.Customer;
import com.nissan.repo.IAdminRepository;

@Service
public class AdminServiecImpl implements IAdminService {

	@Autowired
	IAdminRepository adminRepo;
	
	//adding customer
	@Transactional
	@Override
	public Customer addCustomer(Customer customer) {
		return adminRepo.save(customer);
	}

	@Override
	public List<Customer> listCustomers() {
		return adminRepo.findAll();
	}

	//Updating customer details
	@Transactional
	@Override
	public Customer updateCustomer(Customer customer) {
		return adminRepo.save(customer);
	}

	@Transactional
	@Override
	public Customer disableCustomer(int customerId) {
		Optional<Customer> customerOp = adminRepo.findById(customerId);
		if(customerOp!=null) {
			Customer customer = customerOp.get();
			customer.setDisabled(true);			
			return adminRepo.save(customer);
		}
		return null;
		
	}

}
