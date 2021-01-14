package com.onuranli.restful.webservices.restfulwebservices.ders4;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)// exception fırlattıgında 200 OK Dönen status 500 olur fakat hata içeriği düzgün verilmesi için bu gereklidir
public class InsureNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8073026432510166044L;
	
	public InsureNotFoundException(String msg) {
		super(msg);
	}

}
