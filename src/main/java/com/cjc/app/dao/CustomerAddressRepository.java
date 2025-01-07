package com.cjc.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cjc.app.Entity.CustomerAddress;
import com.cjc.app.Entity.LocalAddress;
import com.cjc.app.Entity.PermanentAddress;

@Repository
public interface CustomerAddressRepository extends JpaRepository<CustomerAddress, Integer> {

	PermanentAddress save(PermanentAddress permanentAddress);

	LocalAddress save(LocalAddress localAddress);

}
