package com.cjc.app.resource;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cjc.app.Entity.AllpersonalDocument;
import com.cjc.app.Entity.Customer;
import com.cjc.app.Entity.CustomerAddress;
import com.cjc.app.Entity.LocalAddress;
import com.cjc.app.Entity.PermanentAddress;
import com.cjc.app.Entity.SanctionDetails;
import com.cjc.app.dto.AllpersonalDoucumentDTO;
import com.cjc.app.dto.CustomerAddressDTO;
import com.cjc.app.dto.CustomerRequestDTO;
import com.cjc.app.dto.CustomerResponseDTO;
import com.cjc.app.dto.LocalAddressDTO;
import com.cjc.app.dto.PermanentAddressDTO;
import com.cjc.app.dto.SanctionDetailsDTO;
import com.cjc.app.service.AllpersonalDocumentService;
import com.cjc.app.service.CustomerAddressService;
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
import com.cjc.app.service.LocalAddressService;
import com.cjc.app.service.PermanentAddressService;
import com.cjc.app.service.SanctionDetailsService;

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
	private SanctionDetailsService sanctionDetailsService;

  @Autowired
	private AllpersonalDocumentService allpersonalDocumentService;

	@Autowired
	private CustomerAddressService customerAddressService;
	
  @Autowired
	private PermanentAddressService permanentAddressService;

	@Autowired
	private LocalAddressService localAddressService;

	SanctionDetailsService sanctionDetailsService;
	
	@Autowired
	private FamilyService familyService;
	
	@Autowired
    private AllpersonalDoucumentService allpersonalDoucumentService;

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

	public Customer documentUpload(AllpersonalDoucumentDTO documents) {
		AllpersonalDocument personalDocument = modelMapper.map(documents, AllpersonalDocument.class);
		AllpersonalDocument savedpersonalDoucumenet = allpersonalDocumentService.saveDocument(personalDocument);

		if (savedpersonalDoucumenet != null) {
			Customer existingCustomer = loanService.getCustomerId(documents.getCustomerId());
			existingCustomer.setAllpersonaldocument(savedpersonalDoucumenet);
			loanService.saveCustomer(existingCustomer);
			return existingCustomer;
		}
		return null;

	}

	public CustomerAddress saveAddress(PermanentAddressDTO permanentAddressDTO) {
		PermanentAddress permanentAddress = modelMapper.map(permanentAddressDTO, PermanentAddress.class);
		PermanentAddress savedpermanentAddress = permanentAddressService.savePermanentAddress(permanentAddress);
		if (savedpermanentAddress != null) {
			CustomerAddress customerAddress = new CustomerAddress();
			customerAddress = customerAddressService.getcustomerAddressId(permanentAddressDTO.getCustomerAddressId());
			customerAddress.setPermanentAddress(savedpermanentAddress);
			customerAddressService.addCustomerAddress(customerAddress);

			return customerAddress;

		}
		return null;
	}

	public CustomerAddress saveLocalAddress(LocalAddressDTO localAddressDTO) {
		LocalAddress localAddress = modelMapper.map(localAddressDTO, LocalAddress.class);
		LocalAddress savedlocalAddress = localAddressService.saveLocalAddress(localAddress);
		if (savedlocalAddress != null) {
			CustomerAddress customerAddress = new CustomerAddress();
			customerAddress = customerAddressService.getcustomerAddressId(localAddressDTO.getCustomerAddressId());
			customerAddress.setLocalAddress(savedlocalAddress);
			customerAddressService.addCustomerAddress(customerAddress);

			return customerAddress;

		}
		return null;
	}
  
	public Customer saveCustomerAddress(CustomerAddressDTO customerAddressDTO) {
		CustomerAddress customerAddress = new CustomerAddress();
		customerAddress = customerAddressService.getcustomerAddressId(customerAddressDTO.getCustomerAddressId());
		if (customerAddress != null) {
			Customer existingCustomer = new Customer();
			existingCustomer = loanService.getCustomerId(customerAddressDTO.getCustomerId());
			existingCustomer.setCustomeraddress(customerAddress);
			loanService.saveCustomer(existingCustomer);
			return existingCustomer;

		}

		return null;
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
