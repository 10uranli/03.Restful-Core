package com.onuranli.restful.webservices.restfulwebservices.ders6;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	
}
