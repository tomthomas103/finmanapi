package com.thoma.finmanapi.service.impl;

import com.thoma.finmanapi.dto.response.PaginationResponse;
import com.thoma.finmanapi.dto.response.TransactionResponse;
import com.thoma.finmanapi.entity.*;
import com.thoma.finmanapi.dto.mapper.TransactionDetailMapper;
import com.thoma.finmanapi.repository.AccountRepository;
import com.thoma.finmanapi.repository.PartyRepository;
import com.thoma.finmanapi.repository.TransactionDetailRepository;
import com.thoma.finmanapi.dto.request.TransactionDetailRequest;
import com.thoma.finmanapi.service.TransactionService;
import com.thoma.finmanapi.service.UserService;
import com.thoma.finmanapi.util.BasicUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Slf4j
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
    public PaginationResponse<TransactionResponse> listTransactionDetail(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        PaginationResponse<TransactionResponse> response = new PaginationResponse<>();
        Page<TransactionDetail> transactionsPage = transRepo.findAll(pageable);
        List<TransactionResponse> transactionRespList
                = transactionMapper.getTransactionRespListFromEntity(transactionsPage.getContent());
        BasicUtils.setPaginationParameters(response, transactionsPage,transactionRespList);
        response.setData(transactionRespList);
        return response;
    }

    @Override
    public TransactionResponse createNewTransaction(TransactionDetailRequest req){
        TransactionDetail transactionDetail = transactionMapper.getTransactionDetailFromReq(req);
        if(req.getPartyId()!=null){
            transactionDetail.setParty(getParty(req.getPartyId()));
        }
        transactionDetail.setUser(userService.findUserByUsername(req.getUsername()));
        //TODO what if account is null/ invalid.
        transactionDetail.setAccount(getAccount(req.getAccountId()));
        transRepo.save(transactionDetail);
        return transactionMapper.getTransactionRespFromEntity(transactionDetail);
    }

    @Override
    public TransactionDetail updateTransaction(TransactionDetailRequest request) {
        return null;
    }

    @Override
    public TransactionDetail deleteTransaction(Long transactionId) {
        try{
            long success = transRepo.deleteByTransactionId(transactionId);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return null;
    }

    @Override
    public TransactionDetail getTransactionDetail(Long transactionId) {
        return null;
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
