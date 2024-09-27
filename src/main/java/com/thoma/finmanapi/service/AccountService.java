package com.thoma.finmanapi.service;

import com.thoma.finmanapi.dto.request.AccountRequest;
import com.thoma.finmanapi.dto.response.AccountResponse;
import com.thoma.finmanapi.dto.response.PaginationResponse;

public interface AccountService {

    AccountResponse createAccount(AccountRequest accountRequest);

    PaginationResponse<AccountResponse> getAllAccount(int page, int size);
}
