package com.cts.mutualfund.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cts.mutualfund.modal.MutualFund;

@Repository
public interface MutualFundDao extends JpaRepository<MutualFund, Integer>{

	@Query(value = "SELECT * FROM mutual_fund muf, customer_registration cr, account_setup a WHERE muf.pan_no= :panNo  ", nativeQuery = true)
	List<MutualFund> findMutualFundDetails(@Param("panNo")String panNo);
	
	@Query(value = "SELECT * FROM mutual_fund muf WHERE muf.pan_no= :panNo AND muf.fund_id= :fundId", nativeQuery = true)
	List<MutualFund> getMutualFundTransaction(@Param("panNo")String panNo,@Param("fundId") Integer fundId);




}
