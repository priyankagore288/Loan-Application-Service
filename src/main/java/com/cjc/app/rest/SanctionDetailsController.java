package com.cjc.app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.app.Entity.Customer;
import com.cjc.app.dto.CustomerResponseDTO;
import com.cjc.app.dto.SanctionDetailsDTO;
import com.cjc.app.resource.CustomerResource;

@RestController
public class SanctionDetailsController 
{ 
	
@Autowired CustomerResource customerResource;
	
	@PostMapping(value = "/sanction")
	public ResponseEntity<CustomerResponseDTO> saveSanctionDetails(@RequestBody SanctionDetailsDTO sanctionDetailsDTO)
	{   
	  Customer customer=customerResource.saveSanctionDetails(sanctionDetailsDTO);
	 
	 
		return new ResponseEntity<CustomerResponseDTO>(HttpStatus.CREATED);
	}

	
	
}
