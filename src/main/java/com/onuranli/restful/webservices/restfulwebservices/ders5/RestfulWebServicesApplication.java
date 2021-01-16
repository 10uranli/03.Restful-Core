package com.onuranli.restful.webservices.restfulwebservices.ders5;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class RestfulWebServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulWebServicesApplication.class, args);
	}

//	@Bean
//	public LocaleResolver localeResolver(){
//		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
//		localeResolver.setDefaultLocale(Locale.US);
//		return localeResolver;
//	}
//	
	//Bunu LocaleContextHolder.getLocale() ile kullanıyorum.Direkt localden 
	//aldığından sürekle _en gelir.Tekrar headerdan okuyabilmesi icin AcceptHeader'liyi kullanıyoruz.
	@Bean
	public LocaleResolver localeResolver2(){
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}
	//spring.messages.basename=messages application propertiesde kullandım aşağıdakine gerek yok

//	@Bean
//	public ResourceBundleMessageSource bundleMessageSource(){
//		ResourceBundleMessageSource bundleMessageSource = new ResourceBundleMessageSource();
//		bundleMessageSource.setBasename("messages");
//		return bundleMessageSource;
//	}
}
