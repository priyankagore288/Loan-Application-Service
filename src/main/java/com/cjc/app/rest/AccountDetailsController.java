package com.cjc.app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.app.Entity.AccountDetails;
import com.cjc.app.Entity.Customer;
import com.cjc.app.dto.AccountDetailsDTO;
import com.cjc.app.dto.CustomerResponseDTO;
import com.cjc.app.resource.CustomerResource;

@RestController
public class AccountDetailsController {
	@Autowired CustomerResource customerResource;
	
	@PostMapping(value = "/accountDetails")
	public ResponseEntity<CustomerResponseDTO>saveAccountDetials(@RequestBody AccountDetailsDTO accountDetailsDTO)
	
	{
		Customer customer =customerResource.saveAccountDetials(accountDetailsDTO);
		
       // customerResponseDTO.setAccountdetails(accountDetailsDTO);
		return new ResponseEntity<CustomerResponseDTO>(HttpStatus.CREATED);
		
	}

}

