package com.cjc.app.dto;
import com.cjc.app.Entity.CibilScore;
import com.cjc.app.Entity.LoanDisbursement;

import com.cjc.app.Entity.SanctionDetails;

import com.cjc.app.Entity.SanctionLetter;

import com.cjc.app.module.LoanStatus;
import lombok.Data;

@Data
public class CustomerResponseDTO {
	
	private String customerName;
	private String customerDateofBirth;
	private Integer customerAge;
	private Integer requiredTenureYearly;
	private String customerGender;
	private String customerEmail;
	private Double customerMobileNumber;
	private Double customerAdditionMobile;
	private Double customerAmountPaidforHome;	
	private LoanStatus loanStatus;	
	private CibilScore cibilscore;	
	private LoanDisbursement loandisbursement;

    private SanctionDetails sanctionletter;

    private SanctionLetter sanctionletter;

}
