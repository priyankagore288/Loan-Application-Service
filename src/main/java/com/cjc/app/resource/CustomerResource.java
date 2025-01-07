package com.cjc.app.resource;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cjc.app.Entity.AccountDetails;
import com.cjc.app.Entity.Customer;
import com.cjc.app.Entity.SanctionDetails;
import com.cjc.app.dto.AccountDetailsDTO;
import com.cjc.app.dto.CustomerRequestDTO;
import com.cjc.app.dto.CustomerResponseDTO;

import com.cjc.app.dto.SanctionDetailsDTO;
import com.cjc.app.service.AccountDetailsService;

import com.cjc.app.service.LoanService;
import com.cjc.app.service.SanctionDetailsService;



@Component
public class CustomerResource {

	@Autowired
	private LoanService loanService;
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	SanctionDetailsService sanctionDetailsService;
	@Autowired
	AccountDetailsService accountDetailsService;
	

	public CustomerResponseDTO saveCustomer(CustomerRequestDTO customerRequestDTO) {
		Customer customer = modelMapper.map(customerRequestDTO, Customer.class);
		Customer saveCustomer = loanService.saveCustomer(customer);
		if (saveCustomer != null) {
			CustomerResponseDTO customerResponseDTO = modelMapper.map(saveCustomer, CustomerResponseDTO.class);
			return customerResponseDTO;
		}
		return null;
	}

	public Customer saveSanctionDetails(SanctionDetailsDTO sanctionDetailsDTO) {

		SanctionDetails sanctionDetails = modelMapper.map(sanctionDetailsDTO, SanctionDetails.class);
		SanctionDetails saveSanctionDetails = sanctionDetailsService.saveSanctionDetails(sanctionDetails);

		Customer existingCustomer = loanService.getCustomerId(sanctionDetailsDTO.getCustomerId());
		existingCustomer.setSanctiondetails(saveSanctionDetails);
		loanService.saveCustomer(existingCustomer);

		return existingCustomer;

	}

	public Customer saveAccountDetials(AccountDetailsDTO accountDetailsDTO) {
		 AccountDetails accountDetails = modelMapper.map(accountDetailsDTO, AccountDetails.class);
		AccountDetails saveAccountDetials = accountDetailsService.saveAccountDetials(accountDetails);
		
		Customer existingCustomer = loanService.getCustomerId(accountDetailsDTO.getCustomerId());
		
		accountDetails.setAccountHolderName(accountDetailsDTO.getAccountHolderName());
		accountDetails.setAccountNumber(accountDetailsDTO.getAccountNumber());
		existingCustomer.setAccountdetails(saveAccountDetials);
		loanService.saveCustomer(existingCustomer);
		return existingCustomer;
	}

	

}
