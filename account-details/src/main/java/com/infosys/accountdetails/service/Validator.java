package com.infosys.accountdetails.service;

public class Validator {
		
	public Boolean validateUserId(String userId) {
		String regex = "[a-zA-z0-9]+";
		if(userId.matches(regex)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public Boolean validateAccountNumber(int accountNumber) {
		String regex = "[0-9]{6}";
		if((String.valueOf(accountNumber).matches(regex))) {
			return true;
		}
		else {
			return false;
		}
	}
}
