package com.thoma.finmanapi.dto.request;

import com.thoma.finmanapi.entity.AccountGroup;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class AccountRequest extends BaseRequest {

    private String name;
    private String description;
    private AccountGroup accountType;
    private BigDecimal maxLimit;
    private BigDecimal minLimit;
    private Long userid;

}
