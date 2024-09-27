package com.thoma.finmanapi.dto.response;

import com.thoma.finmanapi.entity.*;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class TransactionResponse extends BaseResponse {
    Long transactionId;
    String transactionDate;
    String title;
    String partyId;
    String username;
    String account;
    String category;
    String subCategory;
    String notes;
    String extraLabel;
    String referenceNum;
    BigDecimal amount;
    TransactionType type;
    TransactionStatus status;
}
