package com.cjc.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cjc.app.Entity.AllpersonalDocument;
import com.cjc.app.service.AllpersonalDocumentService;

@Repository
public interface AllpersonalDoucumentRepository extends JpaRepository<AllpersonalDocument, Integer> {

	

}
