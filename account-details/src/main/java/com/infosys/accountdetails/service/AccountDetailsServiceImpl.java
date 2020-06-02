package com.infosys.accountdetails.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.accountdetails.entity.Account;
import com.infosys.accountdetails.entity.Transaction;
import com.infosys.accountdetails.exception.AccountDetailsException;
import com.infosys.accountdetails.model.AccountDTO;
import com.infosys.accountdetails.model.TransactionDTO;
import com.infosys.accountdetails.repository.AccountRepository;
import com.infosys.accountdetails.repository.TransactionRepository;

@Service
public class AccountDetailsServiceImpl implements AccountDetailsService {
	
	@Autowired
	private AccountRepository accountRepo;
	
	@Autowired
	private TransactionRepository transactionRepo;
	
	public List<AccountDTO> getAllAccounts(String userId) throws AccountDetailsException {
		List<Account> accountEntityList = new ArrayList<>();
		List<AccountDTO> accountDtoList = new ArrayList<>();
		accountEntityList = accountRepo.findByUserId(userId);
		if(accountEntityList.isEmpty()) {
			throw new AccountDetailsException("No Accounts for this user");
		}
		for(Account accountEntity : accountEntityList) {
			accountDtoList.add(AccountDTO.prepareEntityToDTO(accountEntity));
		}
		return accountDtoList;
	}
	
	public List<TransactionDTO> getAllTransactions(int accNumber) throws AccountDetailsException {
		List<Transaction> transactionEntityList = new ArrayList<>();
		List<TransactionDTO> transactionDtoList = new ArrayList<>();
		transactionEntityList = transactionRepo.findByAccountNumber(accNumber);
		if(transactionEntityList.isEmpty()) {
			throw new AccountDetailsException("No Transactions for this account");
		}
		for(Transaction transactionEntity : transactionEntityList) {
			transactionDtoList.add(TransactionDTO.prepareEntityToDTO(transactionEntity));
		}
		return transactionDtoList;
	}
}
