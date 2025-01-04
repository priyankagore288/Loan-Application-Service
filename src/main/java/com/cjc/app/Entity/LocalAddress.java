package com.cjc.app.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class LocalAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer localAddressId;
	private String areaname;
	private String cityname;
	private String district;
	private String state;
	private Long pincode;
	private Integer houseNumber;
	private String streetName;

}
