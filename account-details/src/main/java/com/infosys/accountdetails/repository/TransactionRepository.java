package com.infosys.accountdetails.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosys.accountdetails.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, String> {
	public List<Transaction> findByAccountNumber(Integer accountNumber);
}
