package com.cjc.app.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class PermanentAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer permanentAddressId;
	private String areaname;
	private String cityname;
	private String district;
	private String state;
	private String streetName;
	private Integer houseNumber;
	private Long pincode;

}
