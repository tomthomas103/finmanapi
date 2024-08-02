package com.thoma.finmanapi.service.impl;

import com.thoma.finmanapi.dto.request.AccountRequest;
import com.thoma.finmanapi.entity.Account;
import com.thoma.finmanapi.mapper.AccountMapper;
import com.thoma.finmanapi.repository.AccountRepository;
import com.thoma.finmanapi.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accRepo;

    @Autowired
    AccountMapper accMapper;

    @Override
    public Account createAccount(AccountRequest accountRequest){
        Account account = accMapper.getAccountDetailFromReq(accountRequest);
        return accRepo.save(account);
    }

    @Override
    public List<Account> getAllAccount(){
        return accRepo.findAll();
    }

}
