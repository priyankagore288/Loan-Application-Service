package com.cjc.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cjc.app.Entity.Customer;
import com.cjc.app.Entity.CustomerAddress;
@Repository
public interface LoanRepository extends JpaRepository<Customer, Integer> {

	

}
