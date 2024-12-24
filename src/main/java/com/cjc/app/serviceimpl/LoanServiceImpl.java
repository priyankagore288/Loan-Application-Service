package com.cjc.app.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.app.dao.LoanRepository;
import com.cjc.app.service.LoanService;
@Service
public class LoanServiceImpl implements LoanService {
	
  @Autowired LoanRepository loanrepository;
}
