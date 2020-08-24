package com.cts.mutualfund.serviceimpl;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.mutualfund.dao.MutualFundDao;
import com.cts.mutualfund.modal.MutualFund;
import com.cts.mutualfund.service.MutualFundService;

@Service
public class MutualFundServiceimpl implements MutualFundService{

	@Autowired
	MutualFundDao mutualFundDao;


	@Override
	public MutualFund addMutualFundDetails(@Valid MutualFund add) {
		// TODO Auto-generated method stub
		return mutualFundDao.save(add);
	}

	@Override
	public List<MutualFund> getMutualFundDetail(String panNo) {
		
		return mutualFundDao.findMutualFundDetails(panNo) ;
	}

	@Override
	public List<MutualFund> getMutualFundTransactionDetail(String panNo, Integer fundId) {
		
		return mutualFundDao.getMutualFundTransaction(panNo, fundId);
	}

}
