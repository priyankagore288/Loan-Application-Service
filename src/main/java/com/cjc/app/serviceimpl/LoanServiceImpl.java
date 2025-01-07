package com.cjc.app.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.app.Entity.AllpersonalDocument;
import com.cjc.app.Entity.Customer;
import com.cjc.app.dao.AllpersonalDoucumenetRepository;
import com.cjc.app.dao.LoanRepository;
import com.cjc.app.service.LoanService;

@Service
public class LoanServiceImpl implements LoanService {

	@Autowired
	LoanRepository loanrepository;

	@Autowired
	ModelMapper modelMapper;

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

			return optional.get();
		}
		return null;
	}

	@Override
	public boolean deleteCustomer(int customerId) {
		if (loanrepository.existsById(customerId)) {

			loanrepository.deleteById(customerId);
			return true;
		}
		return false;
	}

	@Override

	public Customer getCustomerId(Integer customerId) {

		return loanrepository.findById(customerId).get();
	}

	@Override
	public Customer updateSanctionOnId(Integer customerId, Customer customer) {

		if (loanrepository.existsById(customerId)) {
			customer.setCustomerId(customerId);
			return loanrepository.save(customer);
		}

		return null;

	}

	public void documentUpload(AllpersonalDocument documents) {
		documentRepository.save(documents);
	}

}
