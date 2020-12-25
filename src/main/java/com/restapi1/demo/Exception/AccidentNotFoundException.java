package com.restapi1.demo.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AccidentNotFoundException extends RuntimeException {

	public AccidentNotFoundException(String message) {
		super(message);
	}
}
