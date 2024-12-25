package com.cjc.app.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Ledger {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer IntergerId;
	private String ledgerCreatedDate;
	private Double totalLoanAmount;
	private Double payableAmountwithInterest;
	private Integer tenure;
	private Double monthlyEMI;
	private Double amountPaidtillDate;
	private Double remainingAmount;
	private String nextEmiDateStart;
	private String nextEmiDateEnd;
	private Integer defaulterCount;
	private String previousEmiStatus;
	private String currentMonthEmiStatus;
	private String loanEndDate;
	private String loanStatus;

}
