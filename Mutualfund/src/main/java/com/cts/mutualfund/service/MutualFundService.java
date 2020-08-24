package com.cts.mutualfund.service;

import java.util.List;

import com.cts.mutualfund.modal.MutualFund;

public interface MutualFundService {
	
	public MutualFund addMutualFundDetails(MutualFund add);
	public List<MutualFund> getMutualFundDetail(String panNo);
	public List<MutualFund> getMutualFundTransactionDetail(String panNo, Integer fundId);

}
