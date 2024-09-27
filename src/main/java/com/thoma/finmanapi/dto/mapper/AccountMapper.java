package com.thoma.finmanapi.dto.mapper;

import com.thoma.finmanapi.dto.request.AccountRequest;
import com.thoma.finmanapi.dto.response.AccountResponse;
import com.thoma.finmanapi.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    Account getAccountDetailFromReq(AccountRequest userRequest);

    AccountResponse getAccResponseFromEntity(Account account);

    List<AccountResponse> getAccResponseList(List<Account> account);


}
