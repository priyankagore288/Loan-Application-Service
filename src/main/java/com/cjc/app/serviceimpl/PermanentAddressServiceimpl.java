package com.cjc.app.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.app.Entity.PermanentAddress;
import com.cjc.app.dao.PermanentAddressRepository;
import com.cjc.app.service.PermanentAddressService;
@Service
public class PermanentAddressServiceimpl implements PermanentAddressService {
	@Autowired PermanentAddressRepository permanentAddressRepository;

	@Override
	public PermanentAddress savePermanentAddress(PermanentAddress permanentAddress) {
		
		return permanentAddressRepository.save(permanentAddress);
	}

}
