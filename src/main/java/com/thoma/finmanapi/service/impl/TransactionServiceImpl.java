package com.thoma.finmanapi.service.impl;

import com.thoma.finmanapi.entity.*;
import com.thoma.finmanapi.mapper.TransactionDetailMapper;
import com.thoma.finmanapi.repository.AccountRepository;
import com.thoma.finmanapi.repository.PartyRepository;
import com.thoma.finmanapi.repository.TransactionDetailRepository;
import com.thoma.finmanapi.repository.UserRepository;
import com.thoma.finmanapi.dto.request.TransactionDetailRequest;
import com.thoma.finmanapi.service.TransactionService;
import com.thoma.finmanapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionDetailRepository transRepo;

    @Autowired
    PartyRepository partyRepo;

    @Autowired
    AccountRepository accountRepo;

    @Autowired
    TransactionDetailMapper transactionMapper;

    @Autowired
    UserService userService;

    @Override
    public List<TransactionDetail> listTransactionDetail(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return transRepo.findAll(pageable).getContent();
    }

    public TransactionDetail createNewTransaction(TransactionDetailRequest req){
        TransactionDetail transactionDetail = transactionMapper.getTransactionDetailFromReq(req);
        transactionDetail.setUser(userService.findUserByUsername(req.getUsername()));
        transactionDetail.setParty(getParty(req.getPartyId()));
        transactionDetail.setAccount(getAccount(req.getAccountId()));
        transRepo.save(transactionDetail);
        return transactionDetail;
    }

    private Party getParty(String partyId){
        Optional<Party> partyOp= Optional.ofNullable(partyRepo.findByPartyId(partyId));
        return  Optional.of(partyOp).orElseThrow(NoSuchElementException::new).get();
    }

    private Account getAccount(Long accountId){
        Optional<Account> accountOp=accountRepo.findById(accountId);
        return Optional.of(accountOp).orElseThrow(NoSuchElementException::new).get();
    }
}
