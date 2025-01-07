package com.cjc.app.serviceimpl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.app.Entity.CustomerAddress;


import com.cjc.app.dao.CustomerAddressRepository;
import com.cjc.app.service.CustomerAddressService;

@Service
public class CustomerAddressServiceImpl  implements CustomerAddressService{
 @Autowired 
 private CustomerAddressRepository customerAddressRepository;



@Override
public CustomerAddress addCustomerAddress(CustomerAddress customerAddress) {
	
	return customerAddressRepository.save(customerAddress);
}

@Override
public CustomerAddress getcustomerAddressId(Integer customerAddressId) {
	return customerAddressRepository.findById(customerAddressId).get();
	
}




}
