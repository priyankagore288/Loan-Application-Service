package com.cjc.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cjc.app.Entity.FamilydependetInfo;

@Repository
public interface FamilyRepository extends JpaRepository<FamilydependetInfo, Integer>{

}
