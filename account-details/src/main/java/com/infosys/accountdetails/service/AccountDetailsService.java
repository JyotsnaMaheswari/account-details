package com.infosys.accountdetails.service;

import java.util.List;

import com.infosys.accountdetails.exception.AccountDetailsException;
import com.infosys.accountdetails.model.AccountDTO;
import com.infosys.accountdetails.model.TransactionDTO;


public interface AccountDetailsService {
	public List<AccountDTO> getAllAccounts(String userId) throws AccountDetailsException;

	public List<TransactionDTO> getAllTransactions(int accNumber) throws AccountDetailsException;
}
