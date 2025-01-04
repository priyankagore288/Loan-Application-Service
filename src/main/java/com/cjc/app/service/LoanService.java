package com.cjc.app.service;

import java.util.List;


import com.cjc.app.Entity.Customer;
import com.cjc.app.Entity.SanctionDetails;

import com.cjc.app.Entity.AllpersonalDoucumenet;
import com.cjc.app.Entity.Customer;



public interface LoanService {

	Customer saveCustomer(Customer customer);

	List<Customer> getAllCustomers();

	Customer getCustomer(int customerId);

	boolean deleteCustomer(int customerId);


	Customer getCustomerId(Integer customerId);

	Customer updateSanctionOnId(Integer customerId, Customer customer);
	
	
	

	void documentUpload(AllpersonalDoucumenet documents);

	

	


}
