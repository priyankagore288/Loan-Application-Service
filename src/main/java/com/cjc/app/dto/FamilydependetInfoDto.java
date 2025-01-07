package com.cjc.app.dto;

import lombok.Data;

@Data
public class FamilydependetInfoDto {

	private Integer customerId;
	private Integer noOfFamilyMember;
	private Integer noOfChild;
	private String maritalStatus;
	private String dependentMember;
	private String familyIncome;
}
