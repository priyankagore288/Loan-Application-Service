package com.cjc.app.Entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class LoanDisbursement {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer agreementId;
	private Integer loanNo;
	private String agreementDate;
	private String amountPayType;
	private Double totalAmount;
	private String bankName;
	private Long accountNumber;
	private String IFSCCode;
	private String accountType;
	private Double transferAmount;
	private String paymentStatus;
	private String amountPaidDate;
	
}
