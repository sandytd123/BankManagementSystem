package com.cts.mutualfund.modal;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class MutualFund {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer fundId;
	@Column
	private String fundName;
	// @DecimalMax(value = "2")
	private Long amount;
    @CreationTimestamp
	public LocalDateTime timestamp;

	@ManyToOne
	@JoinColumn(name = "panNo")
	private CustomerRegistration customer;

	@ManyToOne
	@JoinColumn(name = "accountNo")
	private AccountSetup account;

	public MutualFund(Integer fundId, String fundName, Long amount, LocalDateTime timestamp,
			CustomerRegistration customer, AccountSetup account) {
		super();
		this.fundId = fundId;
		this.fundName = fundName;
		this.amount = amount;
		this.timestamp = timestamp;
		this.customer = customer;
		this.account = account;
	}

	public MutualFund() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getFundId() {
		return fundId;
	}

	public void setFundId(Integer fundId) {
		this.fundId = fundId;
	}

	public String getFundName() {
		return fundName;
	}

	public void setFundName(String fundName) {
		this.fundName = fundName;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public CustomerRegistration getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerRegistration customer) {
		this.customer = customer;
	}

	public AccountSetup getAccount() {
		return account;
	}

	public void setAccount(AccountSetup account) {
		this.account = account;
	}
	
	
	
	

}