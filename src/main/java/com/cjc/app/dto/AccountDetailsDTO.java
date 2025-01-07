package com.cjc.app.dto;

import lombok.Data;

@Data
public class AccountDetailsDTO {
	private Integer customerId;
	 private String accounType;
	 private String accountHolderName;
	    private Double accountBalance;
	    private String accountStatus;
	    private Long accountNumber;

}
