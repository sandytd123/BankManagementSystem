package com.cts.accountsetup.modal;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Entity
public class AccountSetup {
	
	
	@Id
    private Long accountNo;
	private String ifscCode;
    private String micrNo;
	private String bankName;
	
	@ManyToOne
	@JoinColumn(name="panNo")
	private CustomerRegistration customer;
	
	 @OneToMany
	    List<MutualFund> mutualfund;

	public AccountSetup() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountSetup(Long accountNo, String ifscCode, String micrNo, String bankName,
			CustomerRegistration customer) {
		super();
		this.accountNo = accountNo;
		this.ifscCode = ifscCode;
		this.micrNo = micrNo;
		this.bankName = bankName;
		this.customer = customer;
	}

	public Long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getMicrNo() {
		return micrNo;
	}

	public void setMicrNo(String micrNo) {
		this.micrNo = micrNo;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public CustomerRegistration getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerRegistration customer) {
		this.customer = customer;
	}
	
	
	
	
	

}
