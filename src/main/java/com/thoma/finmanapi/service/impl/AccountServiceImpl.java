package com.thoma.finmanapi.service.impl;

import com.thoma.finmanapi.dto.request.AccountRequest;
import com.thoma.finmanapi.dto.response.AccountResponse;
import com.thoma.finmanapi.dto.response.PaginationResponse;
import com.thoma.finmanapi.entity.Account;
import com.thoma.finmanapi.entity.User;
import com.thoma.finmanapi.exception.ResourceNotFoundException;
import com.thoma.finmanapi.dto.mapper.AccountMapper;
import com.thoma.finmanapi.repository.AccountRepository;
import com.thoma.finmanapi.service.AccountService;
import com.thoma.finmanapi.service.UserService;
import com.thoma.finmanapi.util.BasicUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public AccountResponse createAccount(AccountRequest accountRequest){
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
        Account accountSave = accRepo.save(account);
        return accMapper.getAccResponseFromEntity(accountSave);
    }

    @Override
    public PaginationResponse<AccountResponse> getAllAccount(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        PaginationResponse<AccountResponse> response = new PaginationResponse<>();
        Page<Account> accRepoAll = accRepo.findAll(pageable);
        List<AccountResponse> content = accMapper.getAccResponseList(accRepoAll.getContent());
        BasicUtils.setPaginationParameters(response,accRepoAll,content);
        return response;
    }

}
