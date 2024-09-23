package com.thoma.finmanapi.dto.request;

import com.thoma.finmanapi.entity.AccountType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class AccountRequest extends BaseRequest {

    private String name;
    private String description;
    private AccountType accountType;
    private BigDecimal maxLimit;
    private BigDecimal minLimit;
    private Long userid;

}
