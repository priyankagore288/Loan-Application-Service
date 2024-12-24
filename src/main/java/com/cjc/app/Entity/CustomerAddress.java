package com.cjc.app.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class CustomerAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerAddressId;
	@OneToOne(cascade = CascadeType.MERGE.DETACH.REMOVE.REFRESH)
	private PermanentAddress permanentAddress;
	@OneToOne(cascade = CascadeType.MERGE.DETACH.REMOVE.REFRESH)
	private LocalAddress localAddress;
}
