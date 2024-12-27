package com.cjc.app.service;

import java.util.List;

import com.cjc.app.Entity.AllpersonalDoucumenet;
import com.cjc.app.Entity.Customer;


public interface LoanService {

	Customer saveCustomer(Customer customer);

	List<Customer> getAllCustomers();

	Customer getCustomer(int customerId);

	boolean deleteCustomer(int customerId);

	void documentUpload(AllpersonalDoucumenet documents);

	

	

}
