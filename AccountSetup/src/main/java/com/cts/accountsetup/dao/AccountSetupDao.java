package com.cts.accountsetup.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.cts.accountsetup.modal.AccountSetup;

@Component
@Repository
public interface AccountSetupDao extends JpaRepository<AccountSetup, Long> {
	
	@Query(value="SELECT * FROM account_setup account where account.pan_no=:panNo", nativeQuery=true)
	public List<AccountSetup> allAccount(@Param("panNo") String panNo);

}
