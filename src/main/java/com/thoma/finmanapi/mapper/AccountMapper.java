package com.thoma.finmanapi.mapper;

import com.thoma.finmanapi.dto.request.AccountRequest;
import com.thoma.finmanapi.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    Account getAccountDetailFromReq(AccountRequest userRequest);
}
