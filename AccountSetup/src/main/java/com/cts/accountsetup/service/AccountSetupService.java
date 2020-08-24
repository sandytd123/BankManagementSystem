package com.cts.accountsetup.service;

import java.util.List;
import java.util.Optional;

import com.cts.accountsetup.modal.AccountSetup;

public interface AccountSetupService {
	
	public AccountSetup addAccountDetails(AccountSetup account);
	public List<AccountSetup> getAccount(String panNo);

}
