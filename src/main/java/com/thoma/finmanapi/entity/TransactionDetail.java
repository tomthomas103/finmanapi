package com.thoma.finmanapi.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Date;

@Getter
@Setter
@Entity
public class TransactionDetail extends BaseEntity {

    @Column
    Long transactionId;

    @Column
    Date transactionDate;

    @Column
    String title;

    //External party
    @ManyToOne
    Party party;

    //Internal user
    @ManyToOne
    User user;

    //Bank Credit
    @ManyToOne
    Account account;

    @Column
    String category;

    @Column
    String subCategory;

    @Column
    String notes;

    @Column
    String extraLabel;

    @Column
    String referenceNum;

    @Column
    BigDecimal amount;

    @Column
    TransactionType type;

    @Column
    TransactionStatus status;
}
