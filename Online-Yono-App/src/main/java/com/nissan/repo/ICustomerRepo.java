package com.nissan.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.nissan.model.Customer;

public interface ICustomerRepo extends JpaRepositoryImplementation<Customer, Integer> {

}
