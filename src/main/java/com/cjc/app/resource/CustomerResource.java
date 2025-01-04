package com.cjc.app.resource;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cjc.app.Entity.Customer;
import com.cjc.app.Entity.SanctionDetails;
import com.cjc.app.dto.CustomerRequestDTO;
import com.cjc.app.dto.CustomerResponseDTO;
import com.cjc.app.dto.SanctionDetailsDTO;
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

	public CustomerResponseDTO saveCustomer(CustomerRequestDTO customerRequestDTO) {
		Customer customer = modelMapper.map(customerRequestDTO, Customer.class);
		Customer saveCustomer = loanService.saveCustomer(customer);
		if(saveCustomer!=null)
		{
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

}
