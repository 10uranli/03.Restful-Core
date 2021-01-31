package com.onuranli.restful.webservices.restfulwebservices.ders8;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Sigorta Bilgilerini Tutar")
@Entity
public class InsuranceBean {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String insuranceType;
	@ApiModelProperty(notes="Sigortalı, kural seti : bir kişinin birden fazla poliçesi olabilsin, poliçede birden fazla sigortalı olamasın")
	@ManyToOne(fetch = FetchType.LAZY)
	private InsuredBean insured;
	/*
	 * FetchType.LAZY : Get yaptığında yükleme esnasında tüm sigortalıları yüklemek mantıkı değilse lazy kullanılmalıdır.Performans için lazy.
	 * FetchType.EAGER 
	 * */
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getInsuranceType() {
		return insuranceType;
	}
	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}
	public InsuredBean getInsured() {
		return insured;
	}
	public void setInsured(InsuredBean insured) {
		this.insured = insured;
	}
}
