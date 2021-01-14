package com.onuranli.restful.webservices.restfulwebservices.ders3;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

	@RequestMapping(method = RequestMethod.GET, path = "/getTeam/{teamName}")
	public Team getTeamNameWithVariable(@PathVariable String teamName){
		Team team = new Team(String.format(" Gs: %s", teamName));
		return team;
	}
}
