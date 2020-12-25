package com.restapi1.demo.restExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.restapi1.demo.Exception.AccidentNotFoundException;
import com.restapi1.demo.Exception.AccidentNotFoundExceptionDetails;
import com.restapi1.demo.Exception.AccidentNotValidatedDetails;
import com.restapi1.demo.Exception.MoteristNotFoundException;
import com.restapi1.demo.Exception.MoteristNotFoundExceptionDetails;
import com.restapi1.demo.Exception.VehicleNotFoundException;
import com.restapi1.demo.Exception.VehicleNotFoundExceptionDetails;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@SuppressWarnings({"unchecked","rawtypes"})
@Slf4j
public class RestHandler {
    @ExceptionHandler(AccidentNotFoundException.class)
    public ResponseEntity<AccidentNotFoundExceptionDetails> handAccidentNotFoundException(AccidentNotFoundException e)
    {
        return new ResponseEntity<>(AccidentNotFoundExceptionDetails.builder()
                   .timestamp(LocalDateTime.now())
                   .status(HttpStatus.NOT_FOUND.value())
                   .title("Resource not Found")
                   .detail(e.getMessage())
                   .developerMessage(e.getClass().getName())
                   .build(),HttpStatus.NOT_FOUND
        );
    }
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<AccidentNotValidatedDetails> handleAccidentNotFoundException (MethodArgumentNotValidException e)
    {
        List<FieldError> fielderrors = e.getBindingResult().getFieldErrors();
        String fields = fielderrors.stream().map(FieldError::getField).collect(Collectors.joining( ", "));
        String fieldsMessage = fielderrors.stream().map(FieldError :: getDefaultMessage).collect(Collectors.joining(", "));

        return new ResponseEntity<>(AccidentNotValidatedDetails.builder()
        .timestamp(LocalDateTime.now())
        .status(HttpStatus.BAD_REQUEST.value())
        .title("Field validation Error")
        .detail("Check the field(s) below")
        .developerMessage(e.getClass().getName())
        .fields(fields)
        .fieldsMessage(fieldsMessage)
        .build(),HttpStatus.BAD_REQUEST );

    }
	public ResponseEntity<MoteristNotFoundExceptionDetails>handleResourcesNotFoundException(MoteristNotFoundException e){
		return new ResponseEntity<>(
				MoteristNotFoundExceptionDetails.builder()
		.timestamp(LocalDateTime.now())
        .status(HttpStatus.NOT_FOUND.value())
        .title("Resource not Found")
        .detail(e.getMessage())
        .developerMessage(e.getClass().getName())
        .build(), HttpStatus.NOT_FOUND);
		
	}
	public ResponseEntity<VehicleNotFoundExceptionDetails>handleResourcesNotFoundException(VehicleNotFoundException e){
		return new ResponseEntity<>(
				VehicleNotFoundExceptionDetails.builder()
		.timestamp(LocalDateTime.now())
        .status(HttpStatus.NOT_FOUND.value())
        .title("Resource not Found")
        .detail(e.getMessage())
        .developerMessage(e.getClass().getName())
        .build(), HttpStatus.NOT_FOUND);
		
	}
}
