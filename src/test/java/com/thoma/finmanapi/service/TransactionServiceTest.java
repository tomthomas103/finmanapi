package com.thoma.finmanapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.thoma.finmanapi.mapper.TransactionDetailMapper;
import com.thoma.finmanapi.repository.AccountRepository;
import com.thoma.finmanapi.repository.PartyRepository;
import com.thoma.finmanapi.repository.UserRepository;
import com.thoma.finmanapi.dto.request.TransactionDetailRequest;
import com.thoma.finmanapi.service.impl.TransactionServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
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

	@Spy
	TransactionDetailMapper mapper = Mappers.getMapper(TransactionDetailMapper.class);

	@Mock
	TransactionDetailRepository transactionRepo;

	@Mock
	UserRepository userRepo;
	@Mock
	PartyRepository partyRepo;
	@Mock
	AccountRepository accountRepo;

	@Test
	void testGetTransactions() {
		List<TransactionDetail> transactionDetails = generateMockData(10);
		Mockito.when(transactionRepo.findAll()).thenReturn(transactionDetails);
		List<TransactionDetail> transactionDetails1 = service.listTransactionDetail();
		assertEquals(10, transactionDetails1.size());
		verify(transactionRepo, times(1)).findAll();
	}

	@Test
	void testCreateTransactions(){
		Mockito.when(userRepo.findByUsername(Mockito.any())).thenReturn(getDummyUser());
		Mockito.when(partyRepo.findByPartyId(Mockito.any())).thenReturn(getParty());
		Mockito.when(accountRepo.findById(Mockito.any())).thenReturn(Optional.of(getTestAccount()));
		TransactionDetail newTransaction = service.createNewTransaction(getTransactionDetailRequest());

	}


	TransactionDetailRequest getTransactionDetailRequest(){
		TransactionDetailRequest request =new TransactionDetailRequest();
		request.setReqId(UUID.randomUUID().toString());
		request.setTransactionId(123333L);
		request.setTransactionDate("2024-01-20");
		request.setTitle("Opening Balance");
		request.setPartyId("1");
		request.setUsername("UnitTestUser");
		request.setAccountId(1L);
		request.setCategory("BANK");
		request.setSubCategory("BANK");
		request.setExtraLabel("");
		request.setNotes("");
		request.setReferenceNum("123123");
		request.setAmount(new BigDecimal("1223"));
		request.setType(TransactionType.CREDIT);
		request.setStatus(TransactionStatus.COMPLETED);
		return  request;
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
