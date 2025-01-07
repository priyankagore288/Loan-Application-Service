package com.cjc.app.dto;

import lombok.Data;

@Data
public class AllpersonalDoucumentDto {

	private Integer customerId;
	
	private byte[] addressProof;
	
	private byte[] panCard;
	
	private byte[] IncomeTax;
	
    private byte[] addharCard;
    
    private byte[] photo;
    
    private byte[] signature;
    
    private byte[] bankCheque;
    
    private byte[] salarySlips;
}
