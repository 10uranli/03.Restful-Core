package com.onuranli.restful.webservices.restfulwebservices.ders6;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = {"features"})//@JsonIgnoreProperties(value = {"features", "id"})
public class FilterBean {

	@JsonIgnore
	private Integer id;
	private String name;
	private Map<String,String> features;
	
	public FilterBean(Integer id, String name, Map<String, String> features) {
		super();
		this.id = id;
		this.name = name;
		this.features = features;
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
	public Map<String,String> getFeatures() {
		features = features == null? new HashMap<String,String>() : features;
		return features;
	}
	public void setFeatures(Map<String,String> features) {
		this.features = features;
	}
}
