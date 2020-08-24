package com.cts.bms.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cts.bms.exception.BankManagementException;
import com.cts.bms.modal.AccountSetup;
//import com.cts.bms.modal.AccountSetup;
import com.cts.bms.modal.CustomerRegistration;
import com.cts.bms.modal.MutualFund;
import com.cts.bms.serviceimpl.CustomerRegistrationServiceImpl;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController()
@RequestMapping("/bank")
public class CustomerRegistrationController {

	@Autowired
	private CustomerRegistrationServiceImpl customerRegistrationServiceImpl;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	CustomerRegistration customer;

	Logger logger = LoggerFactory.getLogger(CustomerRegistration.class);
	
	//-------------- Add new customer to the Bank--------------

	@PostMapping(value = "/addcustomer", produces = "application/json")
	public ResponseEntity<CustomerRegistration> customerRegistration(
			@Valid @RequestBody CustomerRegistration customer) {
		CustomerRegistration add = null;
		try {
			add = customerRegistrationServiceImpl.addcustomer(customer);
		} catch (BankManagementException ex) {
			throw new BankManagementException();
		}
		return new ResponseEntity<CustomerRegistration>(add, HttpStatus.OK);

	}

	// 2. ADD ACCOUNT DETAILS USING REST TEMPLATE

	@PostMapping(value = "/addAccount", produces = "application/json")
	public Object createAccount(@Valid @RequestBody AccountSetup user) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		Object responseEntity = restTemplate.postForObject("http://localhost:8081/addaccount", user, Object.class,
				customer.getPanNo());

		return responseEntity;
	}

	// ------------------------------------------------------------------------------------------

	// 3. ADD MUTUAL FUND DETAILS USING REST TEMPLATE

	@PostMapping(value = "/AddMutualFund", produces = "application/json")
	public MutualFund createMutualFund(@Valid @RequestBody MutualFund fund) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		// MutualFund data = new MutualFund();
		// HttpEntity<?> entity = new HttpEntity<MutualFund>(data, headers);
		MutualFund responseEntity = restTemplate.postForObject("http://localhost:8082/addMutualFunds", fund,
				MutualFund.class, customer.getPanNo());

		return responseEntity;
	}
	//-----------Get details by using panNo using restTemplate-------------

	@GetMapping(value = "/getBypanNo/{panNo}", produces = "application/json")
	@HystrixCommand(fallbackMethod = "getfallback", threadPoolProperties = {
			@HystrixProperty(name = "coreSize", value = "99") })
	public Object getUserById(@PathVariable("panNo") String panNo) {

		final String Url = "http://localhost:8081/getlist/";
		RestTemplate restTemplate = new RestTemplate();
		Object customer = restTemplate.getForObject(Url + panNo, Object.class);
		return customer;
	}
	
	
	//-------GetTransaction details using Resttemplate--------------------

	@GetMapping(value = "/getTransactionDetails/{panNo}", produces = "application/json")
	@HystrixCommand(fallbackMethod = "getfallback", threadPoolProperties = {
			@HystrixProperty(name = "coreSize", value = "99") })
	public ResponseEntity<String> getTransactionDetails(@PathVariable("panNo") String panNo) {

		final String Url = "http://localhost:8082/getFundDetails/{panNo}";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> user = restTemplate.getForEntity(Url, String.class, panNo);
		return user;
	}

	
	//-------GetInvestment Template using Resttemplate----------
	
	
	@GetMapping(value = "/getInvestmentDetails/{panNo}/{fundId}", produces = "application/json")
	public String getTransactionDetails(@PathVariable("panNo") String panNo, @PathVariable("fundId") Integer fundId) {

		final String Url = "http://localhost:8082/getTransactionDetails/{panNo}/{fundId}";
		RestTemplate restTemplate = new RestTemplate();
		String user = restTemplate.getForObject(Url, String.class, panNo, fundId);
		return user;
	}

	public ResponseEntity<String> getfallback(@PathVariable("panNo") String panNo) {
		return (new ResponseEntity<String>("something is wrong!!!", HttpStatus.OK));
	}
}
