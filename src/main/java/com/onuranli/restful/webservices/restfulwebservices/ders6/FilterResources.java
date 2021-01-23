package com.onuranli.restful.webservices.restfulwebservices.ders6;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilterResources {

	@GetMapping(path = "/All")
	public FilterBean retrieveAll(){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("Goz", "Kahverengi");
		map.put("Kilo", "73");
		
		FilterBean bean = new FilterBean(1, "Onur",map);
		return bean;
	}
	
	@GetMapping(path = "/DynamicFilter")
	public MappingJacksonValue retrieveAllWithDynamic(){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("Goz", "Kahverengi");
		map.put("Kilo", "73");
		DynamicBean bean = new DynamicBean(1, "Onur",map);


		/*
		 * mapping.setFilters(filters); ilk kodlarsan filters için create local variables yapınca interface olusur. 
		 * FilterProvider filters; gibi burada bu jar içinden implement eden classlardan SimpleFilterProvider bulabilirsin
		 * (ctrl shift g) 
		 * */
		MappingJacksonValue mapping = new MappingJacksonValue(bean);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("name", "features");
		FilterProvider filters = new SimpleFilterProvider().addFilter("FilterID", filter); 
		mapping.setFilters(filters);
		return mapping;
	}
}
