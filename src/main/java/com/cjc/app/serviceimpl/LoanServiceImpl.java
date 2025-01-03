package com.cjc.app.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.app.Entity.AllpersonalDoucumenet;
import com.cjc.app.Entity.Customer;
import com.cjc.app.dao.AllpersonalDoucumenetRepository;
import com.cjc.app.dao.LoanRepository;
import com.cjc.app.dto.CustomerRequestDTO;
import com.cjc.app.dto.CustomerResponseDTO;
import com.cjc.app.service.LoanService;

@Service
public class LoanServiceImpl implements LoanService {

	@Autowired
	LoanRepository loanrepository;
	
	@Autowired
	AllpersonalDoucumenetRepository documentRepository;

	@Override
	public Customer saveCustomer(Customer customer) {

		return loanrepository.save(customer);
	}

	@Override
	public List<Customer> getAllCustomers() {

		return loanrepository.findAll();
	}
	@Override
	public Customer getCustomer(int customerId) {

		Optional<Customer> optional = loanrepository.findById(customerId);
		if (optional.isPresent()) {
			return optional.get();		}
		return null;
		}
	@Override
	public boolean deleteCustomer(int customerId) {
		if(loanrepository.existsById(customerId))
		{
			loanrepository.deleteById(customerId);
			return true;
		}
		return false;
	}

	@Override
	public void documentUpload(AllpersonalDoucumenet documents) {
		documentRepository.save(documents);
		}
}
