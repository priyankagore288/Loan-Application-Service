package com.cjc.app.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
@Entity
public class SanctionLetter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sanctionId;
	@CreationTimestamp
	private Date sanctionDate;
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
