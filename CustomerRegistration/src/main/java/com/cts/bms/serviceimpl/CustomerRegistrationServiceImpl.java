package com.cts.bms.serviceimpl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cts.bms.dao.CustomerRegistrationDao;
import com.cts.bms.modal.CustomerRegistration;
import com.cts.bms.service.CustomerRegistrationService;


@Service
public class CustomerRegistrationServiceImpl implements CustomerRegistrationService, UserDetailsService {

	@Autowired
	CustomerRegistrationDao customerRegistrationDao;
	
	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;
	
	public CustomerRegistrationServiceImpl(CustomerRegistrationDao customerRegistrationDao ) {
		
		this.customerRegistrationDao=customerRegistrationDao;
	}
	
	

	@Override
	public  CustomerRegistration addcustomer(CustomerRegistration customer) {
		customerRegistrationDao.save(customer);
		customer.setPassword(bcryptEncoder.encode(customer.getPassword()));
        CustomerRegistration customers=  customerRegistrationDao.save(customer);
        return customers;
	}




	public UserDetails loadUserByUsername(String panNo) throws UsernameNotFoundException {
		CustomerRegistration customer  = customerRegistrationDao.findBypanNo(panNo);
		if(customer == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(customer.getPanNo(), customer.getPassword(), getAuthority());
	}


	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_Admin"));
	}


	public CustomerRegistration findOne(String panNo) {
		return customerRegistrationDao.findBypanNo(panNo);
		
		
	}
	
//	public Optional<CustomerRegistration> getUserById(Integer customerId){
//		return customerRegistrationDao.findById(customerId);
//	}

	
	
}
