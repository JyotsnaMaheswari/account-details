package com.infosys.accountdetails.controller;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.infosys.accountdetails.exception.AccountDetailsException;
import com.infosys.accountdetails.service.AccountDetailsService;


@Validated
@RestController
@RequestMapping("/accountdetails")
public class AccountDetailsController {
	
	private static final Logger logger = LogManager.getLogger(AccountDetailsController.class);
	
	@Autowired
	private AccountDetailsService accountService;
	
	//Get request for fetching all accounts of given user
	
	@GetMapping(value="/accounts/{userId}")
	public ResponseEntity<Object> fetchAllAccounts(@PathVariable @Pattern(regexp = "[a-zA-Z0-9]+",message="Username should be alphanumeric") String userId) throws AccountDetailsException {
		logger.info("User logged in with userId: " + userId);
		return new ResponseEntity<>(accountService.getAllAccounts(userId),  HttpStatus.OK);
	}
	
	//Get request for fetching all transactions by giving account number
	
	@GetMapping(value="/transactions/{accountNumber}")
	public ResponseEntity<Object> fetchAllTransactions(@PathVariable @Min(value=100000, message="Account Number should be 6 digit")  @Max(value=999999, message="Account Number should be 6 digit") int accountNumber) throws AccountDetailsException {
		logger.info("Account Number: " + accountNumber);
		return new ResponseEntity<>(accountService.getAllTransactions(accountNumber),  HttpStatus.OK);
	}
}
