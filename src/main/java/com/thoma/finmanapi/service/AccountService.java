package com.thoma.finmanapi.service;

import com.thoma.finmanapi.dto.request.AccountRequest;
import com.thoma.finmanapi.entity.Account;

import java.util.List;

public interface AccountService {

    Account createAccount(AccountRequest accountRequest);

    List<Account> getAllAccount();
}
