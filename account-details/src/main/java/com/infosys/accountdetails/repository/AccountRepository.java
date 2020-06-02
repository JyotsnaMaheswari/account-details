package com.infosys.accountdetails.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosys.accountdetails.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {
	public List<Account> findByUserId(String userId);
}
