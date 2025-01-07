package com.cjc.app.dto;

import lombok.Data;

@Data
public class SanctionDetailsDTO {

	private Integer customerId;
	private String applicantName;
	private Double contactDetails;
	private String producthomeEquiry;
	private Double loanAmtSanctioned;
	private String interestType;
	private Float rateOfInterest;
	private Integer loanTenureInMonth;
	private Double monthlyEmiAmount;
	private String modeOfPayment;
	private String remarks;
	private String termsCondition;
	private String status;

}
