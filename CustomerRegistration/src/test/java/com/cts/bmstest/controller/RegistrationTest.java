package com.cts.bmstest.controller;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cts.bms.CustomerRegistrationApplication;
import com.cts.bms.controller.CustomerRegistrationController;
import com.cts.bms.modal.CustomerRegistration;
import com.cts.bms.serviceimpl.CustomerRegistrationServiceImpl;



@SpringBootTest(classes=CustomerRegistrationApplication.class)
@RunWith(SpringRunner.class)
public class RegistrationTest {
	
	
	@Mock
	CustomerRegistrationServiceImpl customerRegistrationServiceImpl;
	
	private MockMvc mockMvc;
	
	
	@InjectMocks
	CustomerRegistrationController customerRegistrationController;
	
	@Autowired
	CustomerRegistration customer1;
	

	
	@Test
    public void testCustomerregistration(){
		CustomerRegistration customer= new CustomerRegistration("dumbo","jaiswal","11111","4444444","444444","dum911@gmail.com",null,null,null);
		when(customerRegistrationServiceImpl.addcustomer( customer)).thenReturn( customer);
		ResponseEntity<CustomerRegistration> response = customerRegistrationController.customerRegistration( customer);
		assertEquals(response.getStatusCode(),HttpStatus.OK);
		
	}
	

	
	@Test
	public void addCustomerTest() throws Exception {
		when(customerRegistrationServiceImpl.addcustomer(customer1))
				.thenReturn(new CustomerRegistration("dumbo","jaiswal","11111","4444444","444444","dum911@gmail.com",null,null,null));
		assertEquals("dumbo", customerRegistrationServiceImpl.addcustomer(customer1).getFirstName());

	}
	
	
}
