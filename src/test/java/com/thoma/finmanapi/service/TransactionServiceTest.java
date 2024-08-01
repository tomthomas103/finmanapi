package com.thoma.finmanapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.thoma.finmanapi.entity.Account;
import com.thoma.finmanapi.entity.AccountType;
import com.thoma.finmanapi.entity.Party;
import com.thoma.finmanapi.entity.TransactionDetail;
import com.thoma.finmanapi.entity.TransactionStatus;
import com.thoma.finmanapi.entity.TransactionType;
import com.thoma.finmanapi.entity.User;
import com.thoma.finmanapi.repository.TransactionDetailRepository;

@ExtendWith(MockitoExtension.class)
public class TransactionServiceTest {

	@InjectMocks
	TransactionService service =new TransactionServiceImpl();

	@Mock
	TransactionDetailRepository repo;

	@Test
	void testGetTransactions() {
		List<TransactionDetail> transactionDetails = generateMockData(10);
		Mockito.when(repo.findAll()).thenReturn(transactionDetails);
		List<TransactionDetail> transactionDetails1 = service.listTransactionDetail();
		assertEquals(10, transactionDetails1.size());
		verify(repo, times(1)).findAll();
	}

	List<TransactionDetail> generateMockData(int count) {
		TransactionDetail det = new TransactionDetail();
		AtomicInteger i = new AtomicInteger(0);
		return Stream.generate(() -> {
			TransactionDetail detail = new TransactionDetail();
			detail.setId(Math.round(Math.random() * 1000)); // Random ID
			detail.setActive(Math.random() < 0.5); // Random isActive
			detail.setCreatedAt(LocalDateTime.now()); // Current timestamp
			detail.setModifiedAt(LocalDateTime.now()); // Current timestamp
			detail.setDeleted(Math.random() < 0.2); // Random isDeleted
			detail.setCreatedBy("MockUser1"); // Fixed createdBy
			detail.setLastModifiedBy("MockUser1"); // Fixed lastModifiedBy
			detail.setTransactionId(Math.round(Math.random() * 10000)); // Random transactionId
			detail.setTransactionDate(LocalDate.now()); // Current date
			detail.setTitle("Mock Transaction" + i.getAndIncrement()); // Fixed title
			detail.setUser(getDummyUser());
			detail.setParty(getParty());
			detail.setCategory("Bank");
			detail.setSubCategory("Income");
			detail.setAmount(BigDecimal.valueOf(Math.random() * 1000)); // Random amount
			detail.setAccount(getTestAccount()); // Fixed parent account
			detail.setType(TransactionType.CREDIT); // Fixed transaction type
			detail.setStatus(TransactionStatus.COMPLETED); // Fixed transaction status
			return detail;
		}).limit(count).collect(Collectors.toList());
	}

	private Party getParty() {
		Party party = new Party();
		party.setName("Party");
		party.setDescription("PartyDesc");
		return party;
	}

	private User getDummyUser() {
		User user = new User();
		user.setName("User1");
		user.setDescription("User");
		return user;
	}

	private Account getTestAccount() {
		Account account = new Account();
		account.setAccountType(AccountType.SAVINGSACC);
		account.setId(1L);
		account.setActive(true);
		account.setName("HDFC Bank SB");
		account.setDescription("Saving Account");
		account.setMaxLimit(BigDecimal.valueOf(100));
		return account;
	}
}
