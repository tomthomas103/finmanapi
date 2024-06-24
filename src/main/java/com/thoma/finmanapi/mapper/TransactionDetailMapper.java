package com.thoma.finmanapi.mapper;

import com.thoma.finmanapi.entity.TransactionDetail;
import com.thoma.finmanapi.request.TransactionDetailRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface  TransactionDetailMapper {

    @Mapping(target="id",ignore = true)
    @Mapping(target = "isActive", ignore = true)
    @Mapping(target="createdAt",ignore = true)
    @Mapping(target="modifiedAt",ignore = true)
    @Mapping(target="isDeleted",ignore = true)
    @Mapping(target="createdBy",ignore = true)
    @Mapping(target="lastModifiedBy",ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target="party",  ignore = true)
    @Mapping(target="account",  ignore = true)
    TransactionDetail getTransactionDetail(TransactionDetailRequest request);
}
