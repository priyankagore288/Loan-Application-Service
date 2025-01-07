package com.cjc.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cjc.app.Entity.AllpersonalDoucument;
@Repository
public interface AllpersonalDoucumenetRepository extends JpaRepository<AllpersonalDoucument, Integer>{

}
