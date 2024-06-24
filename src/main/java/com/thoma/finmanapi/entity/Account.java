package com.thoma.finmanapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.math.BigDecimal;

@Entity
public class Account extends BaseEntity {

    @Column
    String name;

    @Column
    String description;

    @Column
    AccountType accountType;

    @Column
    BigDecimal maxLimit;

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public AccountType getAccountType() {
        return this.accountType;
    }

    public BigDecimal getMaxLimit() {
        return this.maxLimit;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public void setMaxLimit(BigDecimal maxLimit) {
        this.maxLimit = maxLimit;
    }
}
