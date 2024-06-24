package com.thoma.finmanapi.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class TransactionDetail extends BaseEntity {

    @Column
    Long transactionId;

    @Column
    LocalDate transactionDate;

    @Column
    String title;

    @ManyToOne
    Party party;

    @ManyToOne
    UserEntity user;

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

    public Long getTransactionId() {
        return this.transactionId;
    }

    public LocalDate getTransactionDate() {
        return this.transactionDate;
    }

    public String getTitle() {
        return this.title;
    }

    public Party getParty() {
        return this.party;
    }

    public UserEntity getUser() {
        return this.user;
    }

    public Account getAccount() {
        return this.account;
    }

    public String getCategory() {
        return this.category;
    }

    public String getSubCategory() {
        return this.subCategory;
    }

    public String getNotes() {
        return this.notes;
    }

    public String getExtraLabel() {
        return this.extraLabel;
    }

    public String getReferenceNum() {
        return this.referenceNum;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public TransactionType getType() {
        return this.type;
    }

    public TransactionStatus getStatus() {
        return this.status;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setParty(Party party) {
        this.party = party;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setExtraLabel(String extraLabel) {
        this.extraLabel = extraLabel;
    }

    public void setReferenceNum(String referenceNum) {
        this.referenceNum = referenceNum;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }
}
