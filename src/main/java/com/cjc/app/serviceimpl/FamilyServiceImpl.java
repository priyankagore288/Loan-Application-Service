package com.cjc.app.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.app.Entity.FamilydependetInfo;
import com.cjc.app.dao.FamilyRepository;
import com.cjc.app.service.FamilyService;

@Service
public class FamilyServiceImpl implements FamilyService{

	@Autowired FamilyRepository familyRepository;

	@Override
	public FamilydependetInfo saveFamilyInfo(FamilydependetInfo familyInfo) {
		
		return familyRepository.save(familyInfo);
	}
}
