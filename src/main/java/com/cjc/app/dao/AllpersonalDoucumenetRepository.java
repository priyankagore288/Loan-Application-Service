package com.cjc.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cjc.app.Entity.AllpersonalDoucumenet;
@Repository
public interface AllpersonalDoucumenetRepository extends JpaRepository<AllpersonalDoucumenet, Integer>{

}
