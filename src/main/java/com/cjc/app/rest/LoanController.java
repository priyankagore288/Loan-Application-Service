package com.cjc.app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.app.service.LoanService;

@RestController
public class LoanController {
  @Autowired LoanService loanservice;
}
