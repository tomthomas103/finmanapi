package com.thoma.finmanapi.service;

import com.thoma.finmanapi.entity.*;
import com.thoma.finmanapi.mapper.BaseDetailMapper;
import com.thoma.finmanapi.repository.AccountRepository;
import com.thoma.finmanapi.repository.PartyRepository;
import com.thoma.finmanapi.repository.TransactionDetailRepository;
import com.thoma.finmanapi.repository.UserRepository;
import com.thoma.finmanapi.request.DummyReq;
import com.thoma.finmanapi.request.TransactionDetailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionDetailRepository transRepo;

    @Autowired
    UserRepository userRepo;

    @Autowired
    PartyRepository partyRepo;

    @Autowired
    AccountRepository accountRepo;

//    @Autowired
//    TransactionDetailMapper transactionMapper;
//
//    private final TransactionDetailMapper transactionMapper;
//
//    @Autowired
//    public TransactionServiceImpl(TransactionDetailMapper transactionMapper) {
//        this.transactionMapper = transactionMapper;
//    }
    @Autowired
    BaseDetailMapper baseDetailMapper;

    @Override
    public List<TransactionDetail> listTransactionDetail(){
        return transRepo.findAll();
    }

    public TransactionDetail createNewTransaction(TransactionDetailRequest req){
        DummyReq request= new DummyReq();
        request.setIdDummy(123123123L);
        request.setActive(true);
        DummyEntity baseEntity = baseDetailMapper.requestToEntity(request);
       // TransactionDetail transactionDetail = transactionMapper.getTransactionDetail(req);
        System.out.println(baseEntity.getIdDummy());
       // transactionDetail.setUser(getUser(req.getUsername()));
       // transactionDetail.setParty(getParty(req.getPartyId()));
        //transactionDetail.setAccount(getAccount(req.getAccountId()));

        //transRepo.save(transactionDetail);
        return null;
    }

    private Party getParty(String partyId){
        Optional<Party> partyOp= Optional.ofNullable(partyRepo.findByPartyId(partyId));
        return  Optional.of(partyOp).orElseThrow(NoSuchElementException::new).get();
    }

    private User getUser(String userId) {
        Optional<User> userOp= Optional.ofNullable(userRepo.findByUsername(userId));
        return  Optional.of(userOp).orElseThrow(NoSuchElementException::new).get();
    }

    private Account getAccount(Long accountId){
        Optional<Account> accountOp=accountRepo.findById(accountId);
        return Optional.of(accountOp).orElseThrow(NoSuchElementException::new).get();
    }
}
