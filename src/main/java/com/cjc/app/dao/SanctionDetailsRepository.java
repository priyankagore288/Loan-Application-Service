package com.cjc.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cjc.app.Entity.SanctionDetails;

@Repository
public interface SanctionDetailsRepository extends JpaRepository<SanctionDetails, Integer> {

}
