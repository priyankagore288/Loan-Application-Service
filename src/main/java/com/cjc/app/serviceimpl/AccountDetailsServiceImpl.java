package com.cjc.app.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.app.Entity.AccountDetails;
import com.cjc.app.Entity.Customer;
import com.cjc.app.dao.AccountDetailsRepository;
import com.cjc.app.dao.LoanRepository;
import com.cjc.app.dto.AccountDetailsDTO;
import com.cjc.app.service.AccountDetailsService;

@Service
public class AccountDetailsServiceImpl implements AccountDetailsService {
	@Autowired
	AccountDetailsRepository accountDetailsRepository;
@Autowired LoanRepository loanRepository;
	@Override
	public AccountDetails saveAccountDetials(AccountDetails accountDetails) {
		Customer customer = new Customer();
		
			     
		//accountDetails.setAccountHolderName(accountDetails.getAccountHolderName());
		// accountDetails.setAccountHolderName(customer.getCustomerName());
		//accountDetails.setAccountHolderName(customer.getCustomerName());
		return accountDetailsRepository.save(accountDetails);
	}
}
