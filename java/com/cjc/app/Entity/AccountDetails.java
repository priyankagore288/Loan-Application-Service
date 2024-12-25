package com.cjc.app.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class AccountDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer accountId;
    private String accounType;
    private Double accountBalance;
    private String accountHolderName;
    private String accountStatus;
    private Long accountNumber;
}
