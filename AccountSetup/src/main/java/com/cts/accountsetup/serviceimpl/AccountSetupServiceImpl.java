package com.cts.accountsetup.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.accountsetup.dao.AccountSetupDao;
import com.cts.accountsetup.modal.AccountSetup;
import com.cts.accountsetup.service.AccountSetupService;

@Service
public class AccountSetupServiceImpl implements AccountSetupService{
	
	
	@Autowired
	private AccountSetupDao accountSetupDao;

	@Override
	public AccountSetup addAccountDetails(AccountSetup account) {
	
		return accountSetupDao.save(account);
	}

	@Override
	public List<AccountSetup> getAccount(String panNo) {
		
		return accountSetupDao.allAccount(panNo);
	}

}
