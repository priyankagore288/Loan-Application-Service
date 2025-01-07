package com.cjc.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cjc.app.Entity.LocalAddress;

@Repository
public interface LocalAddressRepository extends JpaRepository<LocalAddress, Integer> {

}
