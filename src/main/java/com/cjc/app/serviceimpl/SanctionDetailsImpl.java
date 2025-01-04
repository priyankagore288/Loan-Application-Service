package com.cjc.app.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.app.Entity.SanctionDetails;
import com.cjc.app.dao.SanctionDetailsRepository;
import com.cjc.app.service.SanctionDetailsService;

@Service
public class SanctionDetailsImpl implements SanctionDetailsService {

	@Autowired
	private SanctionDetailsRepository sanctionDetailsRepository;

	@Override
	public SanctionDetails saveSanctionDetails(SanctionDetails sanctionDetails) {
		return sanctionDetailsRepository.save(sanctionDetails);

	}

}
