package com.cjc.app.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.cjc.app.module.LoanStatus;

import lombok.Data;

@Entity
@Data
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	@Enumerated(EnumType.STRING)
	private LoanStatus loanStatus;
	@OneToOne(cascade = CascadeType.MERGE.DETACH.REMOVE.REFRESH)
	private AllpersonalDocument allpersonaldocument;
	@OneToOne(cascade = CascadeType.MERGE.DETACH.REMOVE.REFRESH)
	private FamilydependetInfo familydependetinfo;
	@OneToOne(cascade = CascadeType.MERGE.DETACH.REMOVE.REFRESH)
	private CustomerAddress customeraddress;
	// @OneToOne(cascade = CascadeType.MERGE.DETACH.REMOVE.REFRESH)
	// private CibilScore cibilscore;
	@OneToOne(cascade = CascadeType.MERGE.DETACH.REMOVE.REFRESH)
	private AccountDetails accountdetails;
	@OneToOne(cascade = CascadeType.MERGE.DETACH.REMOVE.REFRESH)
	private GurantorDetails gurantordetails;
	@OneToOne(cascade = CascadeType.MERGE.DETACH.REMOVE.REFRESH)
	private LoanDisbursement loandisbursement;
	// @OneToMany(cascade = CascadeType.MERGE.DETACH.REMOVE.REFRESH)
	// private Ledger ledger;
	@OneToOne(cascade = CascadeType.MERGE.DETACH.REMOVE.REFRESH)
	private SanctionDetails sanctiondetails;
	
	@OneToOne(cascade = CascadeType.MERGE.DETACH.REMOVE.REFRESH)
	private CustomerVerification customerverification;

	@OneToOne(cascade = CascadeType.MERGE.DETACH.REMOVE.REFRESH)
	private SanctionLetter sanctionletter;

}
