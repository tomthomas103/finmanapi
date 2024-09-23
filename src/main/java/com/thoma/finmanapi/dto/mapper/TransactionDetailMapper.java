package com.thoma.finmanapi.dto.mapper;


import com.thoma.finmanapi.dto.response.TransactionResponse;
import com.thoma.finmanapi.entity.TransactionDetail;
import com.thoma.finmanapi.dto.request.TransactionDetailRequest;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Mapper(componentModel = "spring")
public interface TransactionDetailMapper {

    TransactionDetailMapper INSTANCE = Mappers.getMapper(TransactionDetailMapper.class);
    @Slf4j
    final class log
    {}

    @Mapping(target = "transactionDate", source = "transactionDate", qualifiedByName = "stringToDate")
    TransactionDetail getTransactionDetailFromReq(TransactionDetailRequest request);

    List<TransactionResponse> getTransactionRespListFromEntity(List<TransactionDetail> transaction);

    @Mapping(target = "account", source = "account.id")
    @Mapping(target = "partyId", source = "party.id")
    @Mapping(target = "username", source = "user.username")
    TransactionResponse getTransactionRespFromEntity(TransactionDetail transaction);



    @org.mapstruct.Named("stringToDate")
    default Date mapStringToLocalDate(String date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    try{
        return date != null ? formatter.parse(date): null;
    }catch (ParseException e){
        log.log.error(e.getMessage());
        throw new RuntimeException("Parsing Error");
    }

    }

}
