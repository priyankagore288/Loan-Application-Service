package com.cjc.app.dto;

import lombok.Data;

@Data
public class PermanentAddressDTO {
	private Integer customerAddressId;
	private String areaname;
	private String cityname;
	private String district;
	private String state;
	private String streetName;
	private Integer houseNumber;
	private Long pincode;
}
