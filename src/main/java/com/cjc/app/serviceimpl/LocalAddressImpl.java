package com.cjc.app.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.app.Entity.LocalAddress;
import com.cjc.app.dao.LocalAddressRepository;
import com.cjc.app.service.LocalAddressService;

@Service
public class LocalAddressImpl  implements LocalAddressService{
	
	@Autowired LocalAddressRepository localAddressRepository;

	@Override
	public LocalAddress saveLocalAddress(LocalAddress localAddress) {
		return localAddressRepository.save(localAddress);
	}

}
