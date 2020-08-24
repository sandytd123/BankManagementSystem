package com.cts.accountsetup.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.accountsetup.modal.AccountSetup;
import com.cts.accountsetup.serviceimpl.AccountSetupServiceImpl;


@RestController
public class AccountSetupController {
	
	@Autowired
	private AccountSetupServiceImpl accountSetupServiceImpl;
	
	@PostMapping(value="/addaccount",produces="application/json")
	public ResponseEntity<AccountSetup> adddetails(@Valid @RequestBody AccountSetup account){
		
	AccountSetup add= accountSetupServiceImpl.addAccountDetails(account);
	return new ResponseEntity<AccountSetup>(add, HttpStatus.OK);
	}
	
	
	@GetMapping(value="/getlist/{panNo}")
	public  List<AccountSetup> getAllAccount(@PathVariable String panNo){
		return accountSetupServiceImpl.getAccount(panNo);
		
	}
	
}
	
	
	


