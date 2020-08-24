package com.cts.accountsetup.modal;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Entity
public class CustomerRegistration {
	
	/*@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer customerId;*/
	 	
	//@NotEmpty(message="firstName may not be empty")
	private String firstName;
	
	//@NotEmpty(message="lastName may not be empty")
	private String lastName;
	
	@Id
	//@Column(unique=true)
//	@NotEmpty(message="panNo may not be empty")
	private String panNo;
	
	//@NotEmpty(message="password may not be empty")
	private String password;
	
	@Transient
	private String confirmPassword;
	//@AssertTrue(message="confirmPassword field should be equal than pass field")
	//private boolean isValid(){
		//return this.password.equals(this.confirmPassword);
	//}
	
	@Email
//	@NotEmpty(message="emailId may not be empty")
	@Column(unique=true)
	private String emailId;
	
	@JsonFormat(pattern="MM/dd/yyyy")
	private LocalDate dob;
	
/*	@NotNull
	@Digits(integer=10, fraction = 0)*/
	private Long contactNo;
	
	
    @OneToMany
	private List<AccountSetup> totalaccount;


	public CustomerRegistration() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CustomerRegistration(String firstName, String lastName, String panNo, String password, String confirmPassword,
			@Email String emailId, LocalDate dob, Long contactNo, List<AccountSetup> totalaccount) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.panNo = panNo;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.emailId = emailId;
		this.dob = dob;
		this.contactNo = contactNo;
		this.totalaccount = totalaccount;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getPanNo() {
		return panNo;
	}


	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getConfirmPassword() {
		return confirmPassword;
	}


	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public LocalDate getDob() {
		return dob;
	}


	public void setDob(LocalDate dob) {
		this.dob = dob;
	}


	public Long getContactNo() {
		return contactNo;
	}


	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}


	public List<AccountSetup> getTotalaccount() {
		return totalaccount;
	}


	public void setTotalaccount(List<AccountSetup> totalaccount) {
		this.totalaccount = totalaccount;
	}
    
    
    
    
	
}
	
	