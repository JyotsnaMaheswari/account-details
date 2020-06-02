package com.infosys.accountdetails.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.infosys.accountdetails.entity.Account;
import com.infosys.accountdetails.entity.Transaction;
import com.infosys.accountdetails.exception.AccountDetailsException;
import com.infosys.accountdetails.model.AccountDTO;
import com.infosys.accountdetails.model.TransactionDTO;
import com.infosys.accountdetails.repository.AccountRepository;
import com.infosys.accountdetails.repository.TransactionRepository;
import com.infosys.accountdetails.service.AccountDetailsServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountDetailaServiceTest {
	
	@InjectMocks
	private AccountDetailsServiceImpl accServiceImplMock;
	
	@Mock
	private AccountRepository accountRepo;
	
	@Mock
	private TransactionRepository transactionRepo;
	
	private List<Account> accountsMockList = null;
	private List<Transaction> transactionsMockList = null;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void getAllAccountsTest() throws AccountDetailsException {
		Account account = new Account();
		account.setAccountNumber(585309);
		account.setAccountName("SGSavings726");
		account.setAccountType("Savings");
		account.setBalance(84325.56);
		account.setBalanceDate(LocalDate.of(2018, 11, 8));
		account.setCurrency("SGD");
		account.setUserId("user1");
		accountsMockList = new ArrayList<>();
		accountsMockList.add(account);
		when(accountRepo.findByUserId("user1")).thenReturn((List<Account>) accountsMockList);
		List<AccountDTO> accountsList = accServiceImplMock.getAllAccounts("user1");
		assertEquals(1,accountsList.size());
	}
	
	@Test
	public void getAllTransactionsTest() throws AccountDetailsException {
		Transaction transaction = new Transaction();
		transaction.setAccountNumber(585309);
		transaction.setAccountName("SGSavings726");
		transaction.setCreditAmount(900.0);
		transaction.setCurrency("SGD");
		transaction.setDebitAmount(0.0);
		transaction.setDescription("Amount is credited");
		transaction.setTransactionType("Credit");
		transaction.setTransactionDate(LocalDate.of(2012, 12, 01));
		transactionsMockList = new ArrayList<>();
		transactionsMockList.add(transaction);
		when(transactionRepo.findByAccountNumber(585309)).thenReturn((List<Transaction>) transactionsMockList);
		List<TransactionDTO> transactionList = accServiceImplMock.getAllTransactions(585309);
		assertEquals(1,transactionList.size());
	}
	
	@Test
	public void testAccountsException() {
		Exception exception = assertThrows(AccountDetailsException.class,()->{
			accServiceImplMock.getAllAccounts("user1");
		});
		String expectMessage = "No Accounts for this user";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectMessage));
	}
	
	@Test
	public void testTransactionsException() {
		Exception exception = assertThrows(AccountDetailsException.class,()->{
			accServiceImplMock.getAllTransactions(585345);
		});
		String expectMessage = "No Transactions for this account";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectMessage));
	}
	
}
