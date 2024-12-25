package com.cjc.app.dto;

import lombok.Data;

@Data
public class CustomerRequestDTO {
	private Integer customerId;
	private String customerName;
	private String customerDateofBirth;
	private Integer customerAge;
	private Integer requiredTenureYearly;
	private String customerGender;
	private String customerEmail;
	private Double customerMobileNumber;
	private Double customerAdditionMobile;
	private Double customerAmountPaidforHome;
	private Double customerTotalLoanRequired;

}
