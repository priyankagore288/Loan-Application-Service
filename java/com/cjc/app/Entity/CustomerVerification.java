package com.cjc.app.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
@Entity
public class CustomerVerification {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer verificationID;
	@CreationTimestamp
	private Date verificationDate;
	private String status;
	private String remarks;
}
