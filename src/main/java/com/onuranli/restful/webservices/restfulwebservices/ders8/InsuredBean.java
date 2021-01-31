package com.onuranli.restful.webservices.restfulwebservices.ders8;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(description = "Insured Bean")//Sigortalı bilgilerini tutan bean
@Entity // Entity olduğunu bununla belirtmeliyiz
public class InsuredBean{
	
	@Id//Primary 
	@GeneratedValue//Auto generetad
	private Integer id;
	@Size(min = 2, message = "min 2 characters!") 
	@ApiModelProperty(notes="min 2 karakter olmalı")
	private String name;
	private String surname;
	private Date insuranceDate;
	@ApiModelProperty(notes = "Dask, Konut gibi birden fazla poliçesi olabilsin")
	@OneToMany(mappedBy = "insured")
	private List<InsuranceBean> insurance;
	
	public InsuredBean() {
		//save yaparken eğer default olmazsa hata alır.
	}
	public InsuredBean(Integer id, String name, String surname, Date insuranceDate) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.insuranceDate = insuranceDate;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public Date getInsuranceDate() {
		return insuranceDate;
	}
	public void setInsuranceDate(Date insuranceDate) {
		this.insuranceDate = insuranceDate;
	}
	public List<InsuranceBean> getInsurance() {
		return insurance;
	}
	public void setInsurance(List<InsuranceBean> insurance) {
		this.insurance = insurance;
	}
	
	
}
