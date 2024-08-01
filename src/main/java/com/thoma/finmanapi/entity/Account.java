package com.thoma.finmanapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Account extends BaseEntity {

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private AccountType accountType;

    @Column
    private BigDecimal maxLimit;

    @Column
    private BigDecimal minLimit;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
