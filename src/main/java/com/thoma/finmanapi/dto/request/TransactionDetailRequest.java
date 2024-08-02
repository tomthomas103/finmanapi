package com.thoma.finmanapi.dto.request;

import com.thoma.finmanapi.entity.TransactionStatus;
import com.thoma.finmanapi.entity.TransactionType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class TransactionDetailRequest extends BaseRequest {

    Long transactionId;
    String transactionDate;
    String title;
    String partyId;
    String username;
    Long accountId;

    String category;
    String subCategory;
    String notes;
    String extraLabel;
    String referenceNum;

    BigDecimal amount;

    TransactionType type;
    TransactionStatus status;

}
