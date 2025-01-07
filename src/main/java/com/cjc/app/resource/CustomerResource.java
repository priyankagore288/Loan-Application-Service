package com.cjc.app.resource;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cjc.app.Entity.AllpersonalDoucument;
import com.cjc.app.Entity.Customer;
import com.cjc.app.Entity.FamilydependetInfo;
import com.cjc.app.Entity.SanctionDetails;
import com.cjc.app.dto.AllpersonalDoucumentDto;
import com.cjc.app.dto.CustomerRequestDTO;
import com.cjc.app.dto.CustomerResponseDTO;
import com.cjc.app.dto.FamilydependetInfoDto;
import com.cjc.app.dto.SanctionDetailsDTO;
import com.cjc.app.service.AllpersonalDoucumentService;
import com.cjc.app.service.FamilyService;
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
	private FamilyService familyService;
	
	@Autowired
    private AllpersonalDoucumentService allpersonalDoucumentService;

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


	public Customer saveFamilyInfo(FamilydependetInfoDto familydependetInfoDto) {
		
		FamilydependetInfo familyInfo = modelMapper.map(familydependetInfoDto, FamilydependetInfo.class);
		FamilydependetInfo savefamilydependetInfo=familyService.saveFamilyInfo(familyInfo);
		Customer existingCustomer = loanService.getCustomerId(familydependetInfoDto.getCustomerId());
		existingCustomer.setFamilydependetinfo(savefamilydependetInfo);
		loanService.saveCustomer(existingCustomer);
		
		return existingCustomer;
	}

	public Customer documentUpload(AllpersonalDoucumentDto documents) {
		AllpersonalDoucument personalDoucument = modelMapper.map(documents, AllpersonalDoucument.class);
	    AllpersonalDoucument savedpersonalDoucument=allpersonalDoucumentService.saveDocument(personalDoucument);
	    
	    if(savedpersonalDoucument!=null) {
	    	Customer existingCustomer = loanService.getCustomerId(documents.getCustomerId());
	    	existingCustomer.setAllpersonaldoucument(savedpersonalDoucument);
	    	loanService.saveCustomer(existingCustomer);
	    	return existingCustomer;
	    }
		return null;
	}
}
