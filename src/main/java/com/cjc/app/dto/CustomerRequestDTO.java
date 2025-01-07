package com.cjc.app.dto;



import lombok.Data;

@Data
public class CustomerRequestDTO {
	private Integer customerAddressId;
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
	private String areaname;
	private String cityname;
	private String district;
	private String state;
	private String streetName;
	private Integer houseNumber;
	private Long pincode;
	
	
}
