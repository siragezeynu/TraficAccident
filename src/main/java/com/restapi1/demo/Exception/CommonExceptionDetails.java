package com.restapi1.demo.Exception;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.experimental.SuperBuilder;
@Data
@SuperBuilder
public class CommonExceptionDetails {
	protected String title;
    protected int status;
    protected String detail;
    protected LocalDateTime timestamp;
    protected String developerMessage;
}
