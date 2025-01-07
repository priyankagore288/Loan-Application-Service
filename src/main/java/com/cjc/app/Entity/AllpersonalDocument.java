package com.cjc.app.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.Data;

@Data
@Entity
public class AllpersonalDocument {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer documentID;
    @Lob
	private byte[] addressProof;
    @Lob
	private byte[] panCard;
    @Lob
	private byte[] IncomeTax;
    @Lob
	private byte[] addharCard;
    @Lob
	private byte[] photo;
    @Lob
	private byte[] signature;
    @Lob
	private byte[] bankCheque;
    @Lob
	private byte[] salarySlips;
}
