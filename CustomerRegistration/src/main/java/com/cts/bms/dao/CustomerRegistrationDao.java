package com.cts.bms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.bms.modal.CustomerRegistration;
@Repository
public interface CustomerRegistrationDao extends JpaRepository<CustomerRegistration, String>{

	CustomerRegistration findBypanNo(String panNo);

}
