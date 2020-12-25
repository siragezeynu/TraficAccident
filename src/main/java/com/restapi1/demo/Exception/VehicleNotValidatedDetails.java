package com.restapi1.demo.Exception;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class VehicleNotValidatedDetails extends CommonExceptionDetails{
	private String fields;
    private String fieldsMessage;
}
