package com.onuranli.restful.webservices.restfulwebservices.ders3;

public class Team {

	private String name;
	
	public Team(String name) {
		this.name = name;
	}
	//get metotları olmazsa hata alır.
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Name : " + name;
	}
	
	
}
