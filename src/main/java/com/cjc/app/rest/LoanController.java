package com.cjc.app.rest;

import java.io.IOException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.app.Entity.Customer;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.cjc.app.Entity.AllpersonalDoucument;
import com.cjc.app.dto.AllpersonalDoucumentDto;
import com.cjc.app.dto.CustomerRequestDTO;
import com.cjc.app.dto.CustomerResponseDTO;
import com.cjc.app.resource.CustomerResource;
import com.cjc.app.service.LoanService;

@RestController
@RequestMapping(value = "/customer")
public class LoanController {
	@Autowired
	LoanService loanservice;
	@Autowired
	CustomerResource customerResource;

	@PostMapping(value = "/save-customer")
	public ResponseEntity<CustomerResponseDTO> saveCustomer(@RequestBody CustomerRequestDTO customerRequestDTO) {
		CustomerResponseDTO saveCustomerResponseDTO = customerResource.saveCustomer(customerRequestDTO);
		return new ResponseEntity<CustomerResponseDTO>(saveCustomerResponseDTO, HttpStatus.CREATED);
	}

	@GetMapping(value = "/expose-customers")
	public ResponseEntity<List<Customer>> getAllCustomer() {
		List<Customer> customerslist = loanservice.getAllCustomers();
		if (customerslist.isEmpty()) {
			return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Customer>>(customerslist, HttpStatus.OK);

	}

	@GetMapping(value = "/expose-customer/{customerId}")
	public ResponseEntity<Customer> getCustomer(@PathVariable("customerId") int customerId) {
		Customer getcustomer = loanservice.getCustomer(customerId);
		if (getcustomer != null) {
			return new ResponseEntity<Customer>(getcustomer, HttpStatus.OK);
		}
		return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);

	}

	@DeleteMapping(value = "/delete-customer/{customerId}")
	public ResponseEntity<Void> deleteCustomer(@PathVariable int customerId) {
		boolean flag = loanservice.deleteCustomer(customerId);
		if (flag) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

	}

	@PutMapping(value = "/update-sanction/{customerId}")
	public ResponseEntity<Customer> updateSanctionOnId(@PathVariable Integer customerId,
			@RequestBody Customer customer) {

		Customer updatedCustomer = loanservice.updateSanctionOnId(customerId, customer);

		return new ResponseEntity<Customer>(updatedCustomer, HttpStatus.OK);
	}

	@PostMapping(value = "/document-upload")
	public ResponseEntity<Customer> documentUpload(@RequestParam Integer customerId,
			@RequestPart MultipartFile addressProof,
			@RequestPart MultipartFile panCard, @RequestPart MultipartFile IncomeTax,
			@RequestPart MultipartFile addharCard, @RequestPart MultipartFile photo,
			@RequestPart MultipartFile signature, @RequestPart MultipartFile bankCheque,
			@RequestPart MultipartFile salarySlips) throws IOException {

		AllpersonalDoucumentDto documents=new AllpersonalDoucumentDto();
        
		documents.setCustomerId(customerId);
		documents.setAddharCard(addharCard.getBytes());
		documents.setAddressProof(addressProof.getBytes());
		documents.setBankCheque(bankCheque.getBytes());
		documents.setIncomeTax(IncomeTax.getBytes());
		documents.setPanCard(panCard.getBytes());
		documents.setPhoto(photo.getBytes());
		documents.setSalarySlips(salarySlips.getBytes());
		documents.setSignature(signature.getBytes());

		//loanservice.documentUpload(documents);

		Customer customer = customerResource.documentUpload(documents);
		//String msg = "Documents Upload Successfull...!";

		return new ResponseEntity<Customer>(customer, HttpStatus.OK);

	}

}
