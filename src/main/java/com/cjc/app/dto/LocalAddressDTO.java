package com.cjc.app.dto;

import lombok.Data;

@Data
public class LocalAddressDTO {
	private Integer customerAddressId;
	private String areaname;
	private String cityname;
	private String district;
	private String state;
	private Long pincode;
	private Integer houseNumber;
	private String streetName;

}
