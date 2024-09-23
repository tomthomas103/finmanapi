package com.thoma.finmanapi.service.impl;

import com.thoma.finmanapi.dto.request.AccountRequest;
import com.thoma.finmanapi.entity.Account;
import com.thoma.finmanapi.entity.User;
import com.thoma.finmanapi.exception.ResourceNotFoundException;
import com.thoma.finmanapi.dto.mapper.AccountMapper;
import com.thoma.finmanapi.repository.AccountRepository;
import com.thoma.finmanapi.service.AccountService;
import com.thoma.finmanapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accRepo;

    @Autowired
    AccountMapper accMapper;

    @Autowired
    UserService userService;

    @Override
    public Account createAccount(AccountRequest accountRequest){
        Account account = accMapper.getAccountDetailFromReq(accountRequest);
        if(account.getMaxLimit().compareTo(BigDecimal.ZERO) <1){
            account.setMaxLimit(BigDecimal.valueOf(1000000));
        }

        if(accountRequest.getReqId()==null){
            throw new ResourceNotFoundException("User Details is empty");
        }

        User user = userService.findUser(accountRequest.getUserid());
        account.setUser(user);
        //TODO write exceptions scenario.
        //TODO wrap entity to response and return.
        return accRepo.save(account);
    }

    @Override
    public List<Account> getAllAccount(){
        return accRepo.findAll();
    }

}
