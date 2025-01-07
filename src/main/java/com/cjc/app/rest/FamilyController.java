package com.cjc.app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.app.Entity.Customer;
import com.cjc.app.dto.FamilydependetInfoDto;
import com.cjc.app.resource.CustomerResource;

@RestController
public class FamilyController {

	@Autowired CustomerResource customerResource;
	
	@PostMapping(value = "/families")
	public ResponseEntity<Customer> saveFamilyInfo(@RequestBody FamilydependetInfoDto familydependetInfoDto){
		Customer customer = customerResource.saveFamilyInfo(familydependetInfoDto);
		
		return new ResponseEntity<Customer>(customer,HttpStatus.CREATED);
	}
}
