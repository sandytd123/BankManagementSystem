package com.cts.mutualfund.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class AccountSetup {
	
	
	@Id
	//@Length(min=10,max=10)
	private Long accountNo;
	
//	@NotEmpty(message="ifsccode may not be empty")
	private String ifscCode;
	
//	@NotEmpty(message="micrNo may not be empty")
	private String micrNo;
	
	//@NotEmpty(message="bankName may not be empty")
	private String bankName;
		@ManyToOne
	@JoinColumn(name="panNo")
	private CustomerRegistration customer;
	
	
	
	
	

}
