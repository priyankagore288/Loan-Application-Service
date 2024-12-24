package com.cjc.app.Entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	@OneToOne
	private AllpersonalDoucumene allpersonaldoucument;
	@OneToOne
	private FamilydependetInfo  familydependetinfo;
	@OneToOne
    private CustomerAddress  customeraddress;
	@OneToOne
	private CibilScore cibilscore;
	@OneToOne
	private AccountDetails accountdetails;
	@OneToOne
	private GurantorDetails gurantordetails;
	@OneToOne
	private LoanDisbursement loandisbursement;
	@OneToMany
	private Ledger ledger;
	@OneToOne
    private SanctionLetter sanctionletter;
    @OneToOne
	private CustomerVerification customerverification;
	










}
