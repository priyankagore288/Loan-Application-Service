package com.cjc.app.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.app.Entity.AllpersonalDoucument;
import com.cjc.app.dao.AllpersonalDoucumenetRepository;
import com.cjc.app.service.AllpersonalDoucumentService;

@Service
public class AllpersonalDoucumentServiceImpl implements AllpersonalDoucumentService{

	@Autowired
	private AllpersonalDoucumenetRepository allPersonalDocumentRepository;
	@Override
	public AllpersonalDoucument saveDocument(AllpersonalDoucument personalDoucument) {
		
		return allPersonalDocumentRepository.save(personalDoucument);
	}

}
