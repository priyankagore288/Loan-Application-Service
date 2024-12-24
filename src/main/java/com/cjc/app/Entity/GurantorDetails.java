package com.cjc.app.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;

import lombok.Data;

@Data
@Entity
public class GurantorDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer GuarantorId;
	private String GuarantorName;
	private String GuarantorDateOfBirth;
	private String GuarantorRelationshipwithCustomer;
	private Long GuarantorMobileNumber;
	private Long GuarantorAadhardCardNo;
	private String GuarantorMortgageDetails;
	private String GuarantorJobDetails;
	private String GuarantorLocalAddress;
	private String GuarantorPermanentAddress;
}
