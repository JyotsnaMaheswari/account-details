package com.infosys.accountdetails.model;

import java.time.LocalDate;


import com.infosys.accountdetails.entity.Account;


public class AccountDTO {
	private String userId;
	private Integer accountNumber;
	private String accountName;
	private String accountType;
	private LocalDate balanceDate;
	private String currency;
	private Double balance;
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Integer getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public LocalDate getBalanceDate() {
		return balanceDate;
	}
	public void setBalanceDate(LocalDate balanceDate) {
		this.balanceDate = balanceDate;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
	static public AccountDTO prepareEntityToDTO(Account accEntity) {
		AccountDTO accDTO = new AccountDTO();
		accDTO.setUserId(accEntity.getUserId());
		accDTO.setAccountNumber(accEntity.getAccountNumber());
		accDTO.setAccountName(accEntity.getAccountName());
		accDTO.setAccountType(accEntity.getAccountType());
		accDTO.setBalance(accEntity.getBalance());
		accDTO.setBalanceDate(accEntity.getBalanceDate());
		accDTO.setCurrency(accEntity.getCurrency());
		return accDTO;
	}
}
