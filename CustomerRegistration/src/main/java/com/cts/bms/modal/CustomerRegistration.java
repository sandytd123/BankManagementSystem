package com.cts.bms.modal;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Component
public class CustomerRegistration implements Serializable {
	
	
	 	
	@NotEmpty(message="firstName may not be empty")
	private String firstName;
	
	@NotEmpty(message="lastName may not be empty")
	private String lastName;
	
	@Id
	private String panNo;
	
   @NotEmpty(message="password may not be empty")
	private String password;
	
	@Transient
	private String confirmPassword;
   //     @AssertTrue(message="confirmPassword field should be equal than pass field")
	//private boolean isValid(){
	//	return this.password.equals(this.confirmPassword);
	//}
	
	@Email
    @NotEmpty(message="emailId may not be empty")
	@Column(unique=true)
	private String emailId;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="MM/dd/yyyy")
	private Date dob;
	
/*	@NotNull
	@Digits(integer=10, fraction = 0)*/
	private Long contactNo;
	

   @OneToMany
	private List<AccountSetup> totalaccount;
}
	
	