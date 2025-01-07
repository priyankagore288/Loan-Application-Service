package com.cjc.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.cjc.app.Entity.GurantorDetails;

@Repository
public interface GurantorDetailsRepository extends JpaRepository<GurantorDetails, Integer>{

}
