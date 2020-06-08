package com.infosys.accountdetails.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.infosys.accountdetails.service.AccountDetailsService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = AccountDetailsController.class)
public class AccountDetailsControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private AccountDetailsService accountService;
	
	@Test
	public void fetchAllAccountsValidationTest( ) throws Exception {
		mockMvc.perform(get("/accountdetails/accounts/Jyo")).andExpect(status().isOk());
	}
	
	@Test
	public void fetchAllTransactionsValidationTest( ) throws Exception {
		mockMvc.perform(get("/accountdetails/transactions/123456")).andExpect(status().isOk());
	}
}
