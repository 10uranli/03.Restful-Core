package com.onuranli.restful.webservices.restfulwebservices.ders7;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionController {


	@GetMapping(path = "v1/person")
	public PersonV1 personV1(){
		return new PersonV1("Onur");
	}
	
	@GetMapping(path = "v2/person")
	public PersonV2 personV2(){
		return new PersonV2(new Name("Onur", "Anli"));
	}
}
