package com.cjc.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cjc.app.Entity.PermanentAddress;
@Repository
public interface PermanentAddressRepository extends JpaRepository<PermanentAddress, Integer> {

}
