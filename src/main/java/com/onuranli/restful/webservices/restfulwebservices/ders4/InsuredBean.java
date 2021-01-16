package com.onuranli.restful.webservices.restfulwebservices.ders4;

import java.util.Date;

import javax.validation.constraints.Size;

//Sigortalı bilgilerini tutan bean
public class InsuredBean{
	
	private Integer id;
	@Size(min = 2, message = "min 2 characters!") 
	private String name;
	private String surname;
	private Date insuranceDate;
	
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
	
	
}
