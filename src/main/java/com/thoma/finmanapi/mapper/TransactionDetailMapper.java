package com.thoma.finmanapi.mapper;


import com.thoma.finmanapi.entity.TransactionDetail;
import com.thoma.finmanapi.request.TransactionDetailRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Mapper(componentModel = "spring")
public interface TransactionDetailMapper {

    TransactionDetailMapper INSTANCE = Mappers.getMapper(TransactionDetailMapper.class);

    @Mapping(target = "transactionDate", source = "transactionDate", qualifiedByName = "stringToLocalDate")
    TransactionDetail getTransactionDetailFromReq(TransactionDetailRequest request);

    @org.mapstruct.Named("stringToLocalDate")
    default LocalDate mapStringToLocalDate(String date) {
        return date != null ? LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE) : null;
    }

}
