package com.onuranli.restful.webservices.restfulwebservices.ders5;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

	@Autowired
	private MessageSource messageSource;
	
	@RequestMapping(method = RequestMethod.GET, path = "/helloWorld")
	public String helloWorld(@RequestHeader(name= "Accept-Language", required = true) Locale locale){
		return messageSource.getMessage("greeting.message",null, locale);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/helloWorld2")
	public String helloWorld2(){
		return messageSource.getMessage("greeting.message",null, LocaleContextHolder.getLocale());
	}
	
}
