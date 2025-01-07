package com.cjc.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cjc.app.Entity.AccountDetails;
import com.cjc.app.dto.AccountDetailsDTO;
@Repository
public interface AccountDetailsRepository extends JpaRepository<AccountDetails, Integer> {

}
