package com.cts.bmstest.dao;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.bms.CustomerRegistrationApplication;
import com.cts.bms.dao.CustomerRegistrationDao;
import com.cts.bms.modal.CustomerRegistration;


@SpringBootTest(classes=CustomerRegistrationApplication.class)
@RunWith(SpringRunner.class)
public class RegistartionDao {

	@MockBean
	CustomerRegistrationDao repository;

	@Test
	public void testFindByPanNo() {
      CustomerRegistration user =  new CustomerRegistration("dumbo","jaiswal","11111","4444444","444444","dum911@gmail.com",null,null,null);
		when(repository.findBypanNo("11111")).thenReturn(user);
		Assert.assertEquals(user, repository.findBypanNo("11111"));
	}
}
