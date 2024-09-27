package com.thoma.finmanapi.dto.response;

import com.thoma.finmanapi.entity.AccountGroup;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
public class AccountResponse extends BaseResponse{
    private String name;
    private String description;
    private AccountGroup accountType;
    private BigDecimal maxLimit;
    private BigDecimal minLimit;

}
