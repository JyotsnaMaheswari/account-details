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
	
	Validator validator = new Validator();
	
	//To fetch all accounts by giving userId
	public List<AccountDTO> getAllAccounts(String userId) throws AccountDetailsException {
		List<Account> accountEntityList = new ArrayList<>();
		List<AccountDTO> accountDtoList = new ArrayList<>();
		if(validator.validateUserId(userId)) {
			accountEntityList = accountRepo.findByUserId(userId);
			if(accountEntityList.isEmpty()) {
				throw new AccountDetailsException("No Accounts for this user");
			}
			for(Account accountEntity : accountEntityList) {
				AccountDTO accDTO = new AccountDTO();
				accDTO.setUserId(accountEntity.getUserId());
				accDTO.setAccountNumber(accountEntity.getAccountNumber());
				accDTO.setAccountName(accountEntity.getAccountName());
				accDTO.setAccountType(accountEntity.getAccountType());
				accDTO.setBalance(accountEntity.getBalance());
				accDTO.setBalanceDate(accountEntity.getBalanceDate());
				accDTO.setCurrency(accountEntity.getCurrency());
				accountDtoList.add(accDTO);
			}
		}
		else {
			throw new AccountDetailsException("Invalid userId");
		}
		return accountDtoList;
	}
	
	//To fetch all transactions by giving account number
	public List<TransactionDTO> getAllTransactions(int accountNumber) throws AccountDetailsException {
		List<Transaction> transactionEntityList = new ArrayList<>();
		List<TransactionDTO> transactionDtoList = new ArrayList<>();
		if(validator.validateAccountNumber(accountNumber)) {
			transactionEntityList = transactionRepo.findByAccountNumber(accountNumber);
			if(transactionEntityList.isEmpty()) {
				throw new AccountDetailsException("No Transactions for this account");
			}
			for(Transaction transEntity : transactionEntityList) {
				TransactionDTO dto = new TransactionDTO();
				dto.setAccountNumber(transEntity.getAccountNumber());
				dto.setAccountName(transEntity.getAccountName());
				dto.setCreditAmount(transEntity.getCreditAmount());
				dto.setCurrency(transEntity.getCurrency());
				dto.setDebitAmount(transEntity.getDebitAmount());
				dto.setDescription(transEntity.getDescription());
				dto.setTransactionDate(transEntity.getTransactionDate());
				dto.setTransactionType(transEntity.getTransactionType());
				transactionDtoList.add(dto);
			}
		}
		else {
			throw new AccountDetailsException("Invalid account number");
		}
		return transactionDtoList;
	}
}
