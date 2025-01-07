package com.cjc.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cjc.app.Entity.AllpersonalDocument;

public interface documentRepository extends JpaRepository<AllpersonalDocument, Integer> {

}
