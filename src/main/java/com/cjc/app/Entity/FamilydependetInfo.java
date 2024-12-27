package com.cjc.app.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class FamilydependetInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer dependentInfoId;
	private Integer noOfFamilyMember;
	private Integer noOfChild;
	private String maritalStatus;
	private String dependentMember;
	private String familyIncome;
}
