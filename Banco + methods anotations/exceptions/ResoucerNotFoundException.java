package br.com.anderson.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResoucerNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public ResoucerNotFoundException(String ex) {
		super(ex);
	}



}
