package com.thoma.finmanapi.request;

import com.thoma.finmanapi.entity.TransactionStatus;
import com.thoma.finmanapi.entity.TransactionType;

import java.math.BigDecimal;

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

    public Long getTransactionId() {
        return this.transactionId;
    }

    public String getTransactionDate() {
        return this.transactionDate;
    }

    public String getTitle() {
        return this.title;
    }

    public String getPartyId() {
        return this.partyId;
    }

    public String getUsername() {
        return this.username;
    }

    public Long getAccountId() {
        return this.accountId;
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

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
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
