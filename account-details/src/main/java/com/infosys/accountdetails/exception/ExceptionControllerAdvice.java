package com.infosys.accountdetails.exception;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {
	
	private static final Logger logger = LogManager.getLogger(ExceptionControllerAdvice.class);
	
	@ExceptionHandler(AccountDetailsException.class)
	public ResponseEntity<ErrorDetails> exceptionHandler(AccountDetailsException exception) {
		logger.error(exception.getMessage());
		ErrorDetails error = new ErrorDetails();
		error.setErrorCode(406);
		error.setErrorMessage(exception.getMessage());
		return new ResponseEntity<>(error, HttpStatus.NOT_ACCEPTABLE);

	}
	
}
