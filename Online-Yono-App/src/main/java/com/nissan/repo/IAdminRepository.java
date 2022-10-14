package com.nissan.repo;


import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.nissan.model.Customer;

@Repository
public interface IAdminRepository extends JpaRepositoryImplementation<Customer, Integer> {

	

}
