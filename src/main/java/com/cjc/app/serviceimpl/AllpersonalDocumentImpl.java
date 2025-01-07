package com.cjc.app.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.app.Entity.AllpersonalDocument;
import com.cjc.app.dao.AllpersonalDoucumentRepository;

import com.cjc.app.service.AllpersonalDocumentService;

@Service
public class AllpersonalDocumentImpl implements  AllpersonalDocumentService {

	@Autowired AllpersonalDoucumentRepository doucumentRepository;

	

	@Override
	public AllpersonalDocument saveDocument(AllpersonalDocument personalDocument) {
		
		return doucumentRepository.save(personalDocument);
	}

	
	
	
	
		

}
